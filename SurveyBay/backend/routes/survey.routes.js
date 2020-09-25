const router = require('express').Router();
let Survey = require('../models/Survey.model');

router.route('/').get((req, res) => {
  Survey.find()
    .then(surveys => res.json(surveys))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/add').post((req, res) => {
  const user_id = req.body.user_id;
  const title = req.body.title;
  const description = req.body.description;
  const questions = req.body.questions;
  const answers = req.body.answers;
  const status = req.body.status;

  const newExercise = new Survey({
    user_id,
    title,
    description,
    questions,
    answers,
    status
  });

  newExercise.save()
  .then(() => res.json('Survey added!'))
  .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/:id').get((req, res) => {
  Survey.findById(req.params.id)
    .then(survey => res.json(survey))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/:id').delete((req, res) => {
  Survey.findByIdAndDelete(req.params.id)
    .then(() => res.json('Survey deleted.'))
    .catch(err => res.status(400).json('Error: ' + err));
});


router.route('/update/:id').post((req, res) => {
  Survey.findById(req.params.id)
    .then(survey => {
      survey.user_id = req.body.user_id;
      survey.title = req.body.title;
      survey.description = req.body.description;
      survey.questions = req.body.questions;
      survey.answers = req.body.answers;
      survey.status = req.body.status;

      survey.save()
        .then(() => res.json('Survey updated!'))
        .catch(err => res.status(400).json('Error: ' + err));
    })
    .catch(err => res.status(400).json('Error: ' + err));
});

module.exports = router;