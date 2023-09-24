package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Represents a client that can connect to a server, send messages, and receive responses.
 */
public class Client {


    /**
     * Default constructor for the Client class.
     */
    public Client() {
        // Default constructor body (can be left empty)
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
     * Entry method for the Client application.
     * @param args command line arguments (not used in this application).
     * @throws IOException If any I/O error occurs.
     * @throws InterruptedException If the thread is interrupted during sleep
     */
    public static void main(String[] args) throws IOException, InterruptedException {
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

            Thread.sleep(5000);  // Sleep for 5 seconds

        }

        client.cleanup();
    }
}
