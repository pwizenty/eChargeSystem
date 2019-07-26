import React, { Component } from 'react';
import axios from 'axios';
import { Button } from 'reactstrap';
import ReactWebComponent from 'react-web-component';
import Create from './Create';

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      chargingPoints: []
    };
    this.deleteChargingPoint = this.deleteChargingPoint.bind(this);
  }

  componentDidMount() {
    axios.get('http://localhost:8081/chargingPoints')
      .then(res => {
        this.setState({ chargingPoints: res.data });
        console.log(this.state.chargingPoints);
      });
  }

  deleteChargingPoint(id) {
     fetch(`http://localhost:8081/chargingPoints/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      let updatedChargingPoints = [...this.state.chargingPoints].filter(i => i.id !== id);
      this.setState({chargingPoints: updatedChargingPoints});
    });
  }

  render() {
    return (
      <div id="homePage">

        <div className="jumbotron text-center" >
          <h4>PACS - Charging Point</h4>
        </div>

        <div className="container">

          <div className="panel panel-default">

            <div className="panel-heading">
              <h3 className="panel-title">
                Liste der Ladestationen
              </h3>
            </div>

            <div className="panel-body">
              <table className="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>Name</th>
                    <th>Besitzer</th>
                    <th>Löschen</th>
                  </tr>
                </thead>
                <tbody>
                  {this.state.chargingPoints.map(c =>
                    <tr>
                      <td>{c.name}</td>
                      <td>{c.ownerid}</td>
                      <td><Button color="danger" onClick={() => this.deleteChargingPoint(c.id)}>Löschen</Button></td>
                    </tr>
                  )}
                </tbody>
              </table>
            </div>

          </div>

        </div>

      </div>
    );
  }
}
ReactWebComponent.create(<App />, 'chargingpoint-home');
export default App;