package app;

import java.io.IOException;

/**
 * Represents a thread dedicated to running a Server instance. This thread
 * initializes, starts, and cleans up the server. It runs the server on port
 * 6666 and handles any IOExceptions that might arise.
 */
public class ServerThread extends Thread {
	 /**
     * Default constructor for the ServerThread class.
     */
    public ServerThread() {
        // Default constructor body (can be left empty)
    }
	/**
	 * The main logic to be executed when this thread is started. It creates an
	 * instance of the Server, starts it on port 6666, and cleans up after the
	 * server returns.
	 */
	@Override
	public void run() {
		// Create an instance of a Server
		Server server = new Server();

		try {
			// Start the Server on port 6666
			server.start(6666);

			// Cleanup after the server returns
			server.cleanup();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
