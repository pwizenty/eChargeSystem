import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { Redirect } from 'react-router';

class Create extends React.Component {

  constructor() {
    super();
    this.state = {
      name: '',
      ownerid: '',
      toHome: false
    };
  }
  onChange = (e) => {
    const state = this.state
    state[e.target.name] = e.target.value;
    this.setState(state);
  }

  onSubmit = (e) => {
    e.preventDefault();

    const { name, ownerid} = this.state;

    axios.post('http://localhost:8081/chargingPoints', { name, ownerid})
    .then(() => this.setState(() => ({
      toHome: true
    })))
  }

  render() {
    const { name, ownerid} = this.state;

    if (this.state.toHome === true) {
      return <Redirect to='/' />
    }

    return (

      <div id="createComplete">
      <div className="jumbotron text-center">
        <h2>Park and Charge System  - Charging Point</h2>
        <h3>Bitte einen neuen ChargingPoint hinzufügen</h3>
      </div>
      <div className="container">
        <div className="panel panel-default">
          <div className="panel-heading">
            <h3 className="panel-title">
              ADD Charging Point
            </h3>
          </div>
          <div className="panel-body">
            <h4><Link to="/"><span className="glyphicon glyphicon-th-list" aria-hidden="true"></span> Charging Point List</Link></h4>
            <form onSubmit={this.onSubmit}>
              <div className="form-group">
                <label htmlFor="name">Name:</label>
                <input type="text" className="form-control" name="name" value={name} onChange={this.onChange} placeholder="Name" />
              </div>
              <div className="form-group">
                <label htmlFor="ownerid">Besitzer:</label>
                <input type="text" className="form-control" name="ownerid" value={ownerid} onChange={this.onChange} placeholder="Besitzer" />
              </div>
              <button type="submit" className="btn btn-default">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    );
  }
}

export default Create;