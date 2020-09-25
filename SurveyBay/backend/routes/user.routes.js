const router = require('express').Router();
let User = require('../models/user.model');

router.route('/').get((req, res) => {
  User.find()
    .then(users => res.json(users))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/add').post((req, res) => {
  const email = req.body.email;
  const password = req.body.password;
  const first_name = req.body.first_name;
  const last_name = req.body.last_name;

  const newUser = new User({
    email,
    password,
    first_name,
    last_name,
  });

  newUser.save()
  .then(() => res.json('User added!'))
  .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/:id').get((req, res) => {
  User.findById(req.params.id)
    .then(user => res.json(user))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/delete/:id').delete((req, res) => {
  User.findByIdAndDelete(req.params.id)
    .then(() => res.json('User deleted.'))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/authenticate/:email').get((req, res) => {
  User.findByEmail(req.params.email)
  .then(user => res.json(user))
  .catch(err => res.status(400).json('Error: ' + err))

  if (user.email != null) {
    localStorage.store('user', user)
  } else {
    return 
  }
})

router.route('/update/:id').post((req, res) => {
  User.findById(req.params.id)
    .then(user => {
      user.email = req.body.email;
      user.password = req.body.password;
      user.first_name = req.body.first_name;
      user.last_name = req.body.last_name;

      user.save()
        .then(() => res.json('User updated!'))
        .catch(err => res.status(400).json('Error: ' + err));
    })
    .catch(err => res.status(400).json('Error: ' + err));
});

module.exports = router;