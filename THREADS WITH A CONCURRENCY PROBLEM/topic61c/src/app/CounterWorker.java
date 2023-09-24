package app;

/**
 * The CounterWorker class demonstrates the use of the CounterThread class
 * to increment a static counter in parallel threads.
 */
public class CounterWorker {

    /**
     * The main method to execute the CounterWorker demonstration.
     * 
     * @param args the command-line arguments (unused in this case)
     * @throws InterruptedException if any thread has interrupted the current thread
     */
    public static void main(String[] args) throws InterruptedException {
        // Print start message
        System.out.println("This is the initial value of the Counter: " + Counter.getCount());

        // Number of Counters to create
        int numberCounters = 1000;

        // Create 1000 Counters that can each run in their own thread
        CounterThread[] counters = new CounterThread[numberCounters];
        for (int x = 0; x < 1000; ++x) {
            counters[x] = new CounterThread();
        }

        // Start all 1000 Counter threads
        for (int x = 0; x < 1000; ++x) {
            counters[x].start();
        }

        // Wait for 100 Counter threads to finish
        for (int x = 0; x < 1000; x++) {
            counters[x].join();
        }

        // What value did the Counter end up with?
        System.out.println("This is the end value of the Counter: " + Counter.getCount());
    }
}
