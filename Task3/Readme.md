# Real-Time Chat Application

## Overview

This Java-based client-server application enables real-time text communication between multiple users using socket programming and multithreading. The server handles message broadcasting and client connections, while clients can connect to the server to send and receive messages.

## Features

- Real-time message broadcasting
- Multiple concurrent client connections
- User identification with usernames
- Clean exit handling
- Server-side client management
- Simple command interface

## How to Run

### 1. Start the Server

```bash
# Compile server
javac Server/*.java

# Run server
java Server/ChatServer
```

### 2. Start Clients

```bash
# Compile client
javac Client/ChatClient.java

# Run client (in separate terminals)
java Client/ChatClient
```

## Usage Instructions

1. Start the server first
2. Launch multiple client instances
3. When prompted, enter a username
4. Type messages to chat with other clients
5. Type `/exit` to disconnect

## Technical Details

- **Port**: 12345
- **Protocol**: TCP sockets
- **Concurrency**: Thread-per-client model
- **Message Format**: Plain text
- **Dependencies**: Pure Java (no external libraries)

## Sample Workflow

### Server Console:

```
Chat Server starting on port 12345...
Server is running. Waiting for clients...
New client connected: Socket[addr=/127.0.0.1,port=54321,localport=12345]
New client connected: Socket[addr=/127.0.0.1,port=54322,localport=12345]
Alice joined the chat!
Bob joined the chat!
Client disconnected. Total clients: 1
```

### Client 1 (Alice):

```
Connecting to chat server...
Connected to chat server!
Enter your username:
Alice
[Alice]: Hello everyone!
[Bob]: Hi Alice!
```

### Client 2 (Bob):

```
Connecting to chat server...
Connected to chat server!
Enter your username:
Bob
Alice joined the chat!
[Alice]: Hello everyone!
[Bob]: Hi Alice!
Alice left the chat!
```

## Key Components

1. **ChatServer**: Central hub for managing connections and broadcasting messages
2. **ClientHandler**: Thread that manages individual client connections
3. **ChatClient**: User interface for sending/receiving messages

This implementation demonstrates core networking concepts and multithreading in Java while providing a functional real-time chat system.
