import React from 'react';
import List from "./List";
import Form from "./Form";
import axios from 'axios';
/*
Wrapper-Klasse kapselt die Liste und die Form. Definiert zusätzlich weitere Methoden, um angelegte Ladestationen abzufragen
und dies auch zu löschen.
*/
class App extends React.Component{

    constructor(){
        super();
        this.state = {
            chargingPoints: []
        };

    }

    getData = () => {
        axios.get('http://localhost:8081/chargingPoints')
        .then(res => {
            this.setState({ chargingPoints: res.data });
        });
    }

    removeChargingPoints = (id) => {
        let updatedChargingPoints = [...this.state.chargingPoints].filter(i => i.id !== id);
        this.setState({chargingPoints: updatedChargingPoints});
    }
    
    render(){
        return(
        <div id ="chargingPoint">
            <List getData={this.getData} chargingPoints={this.state.chargingPoints}
                 removeChargingPoints = {this.removeChargingPoints}/>
            <Form getData={this.getData}/>
        </div>
        );
    }
}
export default App;