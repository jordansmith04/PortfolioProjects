const router = require('express').Router();
let Response = require('../models/Response.model');

router.route('/').get((req, res) => {
  Response.find()
    .then(exercises => res.json(exercises))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/add').post((req, res) => {
  const survey_id = req.body.survey_id;
  const user_id = req.body.user_id;
  const answers = req.body.answers;
  const status = req.body.status;
  const notes = req.body.notes;

  const newExercise = new Response({
    survey_id,
    user_id,
    answers,
    status,
    notes
  });

  newExercise.save()
  .then(() => res.json('Response added!'))
  .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/:id').get((req, res) => {
  response.findById(req.params.id)
    .then(response => res.json(Response))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/:id').delete((req, res) => {
  Response.findByIdAndDelete(req.params.id)
    .then(() => res.json('Response deleted.'))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/update/:id').post((req, res) => {
  response.findById(req.params.id)
    .then(response => {
      response.survey_id = req.body.survey_id;
      response.user_id = req.body.user_id;
      response.answers = req.body.answers;
      response.status = req.body.status;
      response.notes = req.body.notes;

      response.save()
        .then(() => res.json('Response updated!'))
        .catch(err => res.status(400).json('Error: ' + err));
    })
    .catch(err => res.status(400).json('Error: ' + err));
});

module.exports = router;