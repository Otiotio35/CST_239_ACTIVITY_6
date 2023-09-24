package app;

/**
 * A utility class to manage a static counter.
 */
public class Counter {
	   /** 
     * Default constructor for the Counter class.
     */
    public Counter() {
        // This is the default constructor
    }

    /** Static counter that starts at zero. */
    private static int count = 0;

    /**
     * Thread-safe way to increment the static counter by one.
     */
    public static synchronized void increment() {
        count = count + 1;
    }

    /**
     * Retrieves the current value of the static counter.
     *
     * @return the current counter value
     */
    public static int getCount() {
        return count;
    }
}
