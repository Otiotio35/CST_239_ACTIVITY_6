package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * Represents a client that connects to a server to exchange messages.
 */
public class Client {
	/**
	 * Initializes a new instance of the Client class.
	 */
	public Client() {
	    // ... constructor content ...
	}


    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Connect to the remote Server on the specified IP address and Port.
     *
     * @param ip   Remote IP Address to connect to.
     * @param port Remote Port to connect to.
     * @throws UnknownHostException If the IP address of the host could not be determined.
     * @throws IOException          If any I/O error occurs when creating the socket.
     */
    public void start(String ip, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * Send a Message to the Server.
     *
     * @param msg Message to send.
     * @return Response back from the Server.
     * @throws IOException If any I/O error occurs.
     */
    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        return in.readLine();
    }

    /**
     * Cleanup logic to close all the network connections.
     *
     * @throws IOException If any I/O error occurs when closing the connections.
     */
    public void cleanup() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    /**
     * The main entry point for the Server application.
     *
     * @param args the command-line arguments (not used).
     * @throws IOException if there's an error related to input/output operations.
     */
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start("127.0.0.1", 6666);

        String response;

        for (int count = 0; count < 10; ++count) {
            String message;
            if (count != 9)
                message = "Hello from Client " + count;
             else
                message = ".";
                response = client.sendMessage(message);

            System.out.println("Server response was: " + response);

            if (response.equals("q"))
                break;

        }

        client.cleanup();
    }
}
