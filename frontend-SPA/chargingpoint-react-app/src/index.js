import React from 'react';
import {render, unmountComponentAtNode} from 'react-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/css/bootstrap.css';
import App from './App';

class ReactElement extends HTMLElement{

  constructor() {
    super();
    this.observer = new MutationObserver(() => this.update());
    this.observer.observe(this, { attributes: true });
  }

  connectedCallback() {
    this._innerHTML = this.innerHTML;
    this.mount();
  }

  disconnectedCallback() {
    this.unmount();
    this.observer.disconnect();
  }

  update() {
    this.unmount();
    this.mount();
  }
  mount() {
    render(<App />, this);
  }

  unmount() {
    unmountComponentAtNode(this);
  }
}
customElements.define('chargingpoint-service', ReactElement);