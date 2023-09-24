package app;

/**
 * This is the main entry point for the Server application.
 * It starts a ServerThread and monitors its activity, printing
 * a dot to the console every 5 seconds to indicate that it's running.
 */
public class ServerApp {

    /**
     * Default constructor for the ServerApp class.
     */
    public ServerApp() {
        // Default constructor body (can be left empty)
    }

    /**
     * The main method for the ServerApp class.
     *
     * @param args command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create an instance of a ServerThread
        ServerThread serverThread = new ServerThread();

        // Start the server thread
        serverThread.start();

        // While the server thread is still running, print a dot to the console every 5 seconds
        while (serverThread.isAlive()) {
            System.out.print(".");
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
