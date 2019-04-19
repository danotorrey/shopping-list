import * as React from 'react';
import './App.css';
import ShoppingList from './ShoppingList';

import logo from './logo.svg';

class App extends React.Component<{}, any> {
    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">Welcome to React</h1>
                </header>
                <ShoppingList/>
            </div>
        );
    }
}

export default App;