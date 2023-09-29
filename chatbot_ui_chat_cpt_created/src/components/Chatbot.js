import React, { useState } from 'react';
import './Chatbot.css';

function Chatbot() {
    const [messages, setMessages] = useState([]);
    const [userInput, setUserInput] = useState("");

    const handleSendMessage = () => {
        if (userInput) {
            setMessages([...messages, { sender: 'User', message: userInput }]);
            setUserInput("");

            fetch('http://localhost:8080/api/chatbot', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ message: userInput })
            })
                .then(response => response.json())
                .then(data => {
                    setMessages([...messages, { sender: 'User', message: userInput }, { sender: 'Bot', message: data.response }]);
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }
    };

    return (
        <div className="chatbox">
            <div className="chat-header">Chatbot</div>
            <div className="chat-content">
                {messages.map((msg, index) => (
                    <div key={index} className={msg.sender.toLowerCase()}>
                        {msg.sender}: {msg.message}
                    </div>
                ))}
            </div>
            <div className="chat-footer">
                <input
                    type="text"
                    value={userInput}
                    onChange={e => setUserInput(e.target.value)}
                    placeholder="Type your message..."
                />
                <button onClick={handleSendMessage}>Send</button>
            </div>
        </div>
    );
}

export default Chatbot;
