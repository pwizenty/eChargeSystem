import React from 'react';
import {render, unmountComponentAtNode , ReactDOM} from 'react-dom';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import App from './App'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Create from './components/Create';
import 'bootstrap/dist/css/bootstrap.css';
import htmlToReact from 'html-to-react';

class ReactElement extends HTMLElement {

  constructor() {
    super();
    this.observer = new MutationObserver(() => this.update());
    this.observer.observe(this, { attributes: true });
  }

  connectedCallback() {
    this._innerHTML = this.innerHTML;
    this.mount();
    ReactDOM.render(<Router><div><Route exact path='/' component={App} /><Route path='/create' component={Create} /></div></Router>,
      document.getElementById('root')
    );
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
    const props = {
      ...this.getProps(this.attributes),
      children: this.parseHtmlToReact(this.innerHTML)
    };
    render(<App {...props} />, this);
  }

  unmount() {
    unmountComponentAtNode(this);
  }

  parseHtmlToReact(html) {
    return html && new htmlToReact.Parser().parse(html);
  }

  getProps(attributes, propTypes) {
    propTypes = propTypes|| {};
    return [ ...attributes ]         
      .filter(attr => attr.name !== 'style')         
      .map(attr => this.convert(propTypes, attr.name, attr.value))
      .reduce((props, prop) => 
        ({ ...props, [prop.name]: prop.value }), {});
  }

  getEvents(propTypes) {
    return Object.keys(propTypes)
      .filter(key => /on([A-Z].*)/.exec(key))
      .reduce((events, ev) => ({
        ...events,
        [ev]: args => 
        this.dispatchEvent(new CustomEvent(ev, { ...args }))
      }), {});
  }

  convert(propTypes, attrName, attrValue) {
    const propName = Object.keys(propTypes)
      .find(key => key.toLowerCase() == attrName);
    let value = attrValue;
    if (attrValue === 'true' || attrValue === 'false') 
      value = attrValue == 'true';      
    else if (!isNaN(attrValue) && attrValue !== '') 
      value = +attrValue;      
    else if (/^{.*}/.exec(attrValue)) 
      value = JSON.parse(attrValue);
    return {         
      name: propName ? propName : attrName,         
      value: value      
    };
  }
}
customElements.define('react-el', ReactElement);