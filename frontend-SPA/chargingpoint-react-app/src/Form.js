import React from 'react';
import axios from 'axios';

class Form extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      ownerid: ''
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
    .then(() => this.setState(() => this.props.getData()))
  }

  render() {
    const { name, ownerid} = this.state;

    return (
      <div id="chargingPointForm">
      <div className="container">
        <div className="panel panel-default">
          <div className="panel-heading">
            <h3 className="panel-title">
              Ladestation hinzufügen
            </h3>
          </div>
          <div className="panel-body">
            <form>
              <div className="form-group">
                <label htmlFor="name">Name der Ladestation:</label>
                <input type="text" className="form-control" name="name" value={name} onChange={this.onChange} placeholder="Name" />
              </div>
              <div className="form-group">
                <label htmlFor="ownerid">Besitzer:</label>
                <input type="text" className="form-control" name="ownerid" value={ownerid} onChange={this.onChange} placeholder="Besitzer" />
              </div>
              <button type="submit" className="btn btn-info" onClick={this.onSubmit}>Hinzufügen</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    );
  }
}
export default Form;