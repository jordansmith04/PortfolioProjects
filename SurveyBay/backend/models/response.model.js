const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const responseSchema = new Schema({
  survey_id: { type: Number, required: true },
  user_id: {type: Number, required: true},
  answers: { type: String, required: true },
  status: { type: String, required: true },
  notes: {type: String }
}, {
  timestamps: true,
});

const Response = mongoose.model('Response', responseSchema);

module.exports = Response;