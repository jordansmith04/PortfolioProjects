import React, { Component } from 'react';
import { Link } from 'react-router-dom';

export default class Navbar extends Component {

  render() {
    return (
      <nav className="navbar navbar-dark bg-dark navbar-expand-lg">
        <Link to="/create" className="navbar-brand">SurveyBay</Link>
        <div className="collpase navbar-collapse">
        <ul className="navbar-nav mr-auto">
          <li className="navbar-item">
          <Link to="/create" className="nav-link">Create New Survey</Link>
          </li>
          <li className="navbar-item">
          <Link to="/modify" className="nav-link">Modify Survey</Link>
          </li>
          <li className="navbar-item">
          <Link to="/user" className="nav-link">Edit Profile</Link>
          </li>
        </ul>
        </div>
      </nav>
    );
  }
}