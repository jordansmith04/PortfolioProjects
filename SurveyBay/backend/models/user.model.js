const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const userSchema = new Schema({
  email: { type: String, required: true },
  password: { type: Password, required: true },
  first_name: { type: String, required: true },
  last_name: { type: String, required: true },
}, {
  timestamps: true,
});

const User = mongoose.model('User', userSchema);

module.exports = User;