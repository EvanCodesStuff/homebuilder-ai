import React, { useState, useRef } from 'react';  // <- Import useRef
import './Chatbot.css';

function Chatbot() {
    const [messages, setMessages] = useState([]);
    const [userInput, setUserInput] = useState("");
    const sendButtonRef = useRef(null);  // <- Create a reference for the button

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

    const handleKeyPress = (event) => {
        if (event.key === 'Enter') {
            event.preventDefault(); // Prevents default form submission behavior
            sendButtonRef.current.click();  // <- Trigger the button's click event
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
                    onKeyPress={handleKeyPress} // Add the keypress handler
                    placeholder="Type your message..."
                />
                <button ref={sendButtonRef} onClick={handleSendMessage}>Send</button>  {/* <- Attach the reference to the button */}
            </div>
        </div>
    );
}

export default Chatbot;


