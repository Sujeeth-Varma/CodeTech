import java.net.*;
import java.util.Set;
import java.io.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String username;
    public ClientHandler(Socket socket, Set<ClientHandler> clientHandlers) throws IOException {
        this.clientSocket = socket;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            // Get username
            out.println("Enter your username: ");
            username = in.readLine();
            ChatServer.broadcast(username + " joined the chat!", this);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                if (clientMessage.equalsIgnoreCase("/exit")) {
                    break;
                }
                ChatServer.broadcast("[" + username + "]: " + clientMessage, this);
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
            ChatServer.removeClient(this);
            ChatServer.broadcast(username + " left the chat!", this);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}