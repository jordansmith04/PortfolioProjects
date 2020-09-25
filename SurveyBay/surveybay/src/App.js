import React from 'react';
import './App.css';
import Login from './components/login.component'
import ModifySurvey from './components/modify-survey.component';
import Register from './components/register.component'

function App() {
  return (
    <Router>
      <div className="container">
      <Navbar />
      <br/>
      <Route path="/" exact component={Login} />
      <Route path="/register" component={Register} />
      {/* <Route path="/create" component={CreateExercise} />
      <Route path="/user" component={CreateUser} /> */}
      <Route path="/modify" component={ModifySurvey} />
      </div>
    </Router>
  );
}

export default App;
