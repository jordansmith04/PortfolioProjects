const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const surveySchema = new Schema({
  user_id: { type: Number, required: true },
  title: { type: String, required: true },
  description: { type: String, required: true },
  questions: { type: String, required: true },
  answers: { type: String, required: true },
  status: { type: String, required: true },
}, {
  timestamps: true,
});

const Survey = mongoose.model('Survey', surveySchema);

module.exports = Survey;