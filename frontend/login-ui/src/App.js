import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');

  // Function to handle Registration
  const handleRegister = async () => {
    try {
      await axios.post('http://localhost:8095/api/register', { username, password });
      setMessage('Registration Successful');
    } catch (error) {
      setMessage('Registration Failed');
    }
  };

  // Function to handle Login
  const handleLogin = async () => {
    try {
      await axios.post('http://localhost:8095/api/login', { username, password });
      setMessage('Login Successful');
    } catch (error) {
      setMessage('Invalid Credentials');
    }
  };

  return (
    <div className="App" style={{ padding: '50px' }}>
      <h1>Automation Test Site</h1>

      <div style={{ marginBottom: '20px' }}>
        <input
          id="username" // Selenium will look for this ID!
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </div>

      <div style={{ marginBottom: '20px' }}>
        <input
          id="password" // Selenium will look for this ID!
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>

      <button id="register-btn" onClick={handleRegister} style={{ marginRight: '10px' }}>
        Register
      </button>

      <button id="login-btn" onClick={handleLogin}>
        Login
      </button>

      {/* The robot will check this text to see if the test passed */}
      <h3 id="message-display">{message}</h3>
    </div>
  );
}

export default App;