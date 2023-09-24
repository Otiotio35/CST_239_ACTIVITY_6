package app;

/**
 * The TestMyThreads class demonstrates the creation and starting
 * of threads using both the Thread extension and Runnable implementation approaches.
 *
 * @version 09/24/2023
 * @author toafik otiotio
 */
public class TestMyThreads {
	/**
	 * Default constructor for TestMyThreads.
	 */
	public TestMyThreads() {
	    // Default constructor logic (if any)
	}


    /**
     * The main method showcasing the creation and starting of threads.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {

        // Example of how to create and start a thread that extends the Thread class
        MyThread1 thread1 = new MyThread1();
        thread1.start();

        // Example of how to create and start a thread that implements the Runnable interface
        Runnable runnable = new MyThread2();
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
