import React from 'react';
import List from "./List";
import Form from "./Form";
import ReactWebComponent from 'react-web-component';
import axios from 'axios';

class Wrapper extends React.Component{

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
        <div id ="wrapperComponent">
            <List getData={this.getData} chargingPoints={this.state.chargingPoints}
                 removeChargingPoints = {this.removeChargingPoints}/>
            <Form getData={this.getData}/>
        </div>
        );
    }
}
ReactWebComponent.create(<Wrapper />, 'chargingpoint-create');
export default Wrapper;