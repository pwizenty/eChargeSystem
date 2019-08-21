import React from 'react';
import {render, unmountComponentAtNode} from 'react-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/css/bootstrap.css';
import App from './App';
/*
ReactElement-Klasse ist verantwortlich für das Definieren der Webkomponente 'chargingpoint-service'.
Die Webkomponente wird für die Frontend-Integration genutzt. 
Klasse muss dafür von HTMLElement erben und die verschiedenen Lebenszyklen des neuen HTML-Elements definieren.
 */
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