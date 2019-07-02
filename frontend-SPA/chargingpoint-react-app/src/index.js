import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import App from './App';
import './App.css';
import Create from './components/Create';
import 'bootstrap/dist/css/bootstrap.css';

ReactDOM.render(
  <Router>
      <div>
        <Route exact path='/' component={App} />
        <Route path='/create' component={Create} />
      </div>
  </Router>,
  document.getElementById('root')
);