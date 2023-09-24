package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Represents a server that listens for incoming client connections and exchanges messages with them.
 */
public class Server {
	/**
	 * Initializes a new instance of the Server class.
	 */
	public Server() {
	    // ... constructor content ...
	}


	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	/**
	 * Start the Server and wait for connections on the specified port.
	 *
	 * @param port Port to listen on.
	 * @throws IOException Thrown if an error occurs while starting the server or
	 *                     accepting a connection.
	 */
	public void start(int port) throws IOException {
		System.out.println("Waiting for a Client connection...");
		serverSocket = new ServerSocket(port);

		clientSocket = serverSocket.accept();
		// When you get here, a client connected to this server, so create input and
		// output network buffers.
		System.out.println("Received a Client connection on port " + clientSocket.getLocalPort());

		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		String inputLine;

		while ((inputLine = in.readLine()) != null) {

			if (".".equals(inputLine)) {
				System.out.println("Got a message to shut the Server down");
				out.println("QUIT");
				break;
			} else {
				System.out.println("Got a massage of: " + inputLine);
				out.println("OK");
			}
		}

		System.out.println("Server is shut down.");
	}

	/**
	 * Cleanup logic to close all the network connections.
	 *
	 * @throws IOException Thrown if anything bad happens from the networking
	 *                     classes.
	 */
	public void cleanup() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}
	/**
	 * The main entry point for the Client application.
	 *
	 * @param args the command-line arguments (not used).
	 * @throws IOException if there's an error related to input/output operations.
	 */

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start(6666); // example port
		server.cleanup();
	}
}
