package app;

/**
 * The MyThread1 class demonstrates a simple custom thread by extending the
 * java.lang.Thread class.
 *
 * @version 09/24/2023
 * @author toafik otiotio
 */
public class MyThread1 extends Thread {

    /**
     * Default constructor for MyThread1.
     */
    public MyThread1() {
        // Default constructor logic (if any)
    }

    /**
     * The overridden run method of the Thread class. When an object of MyThread1
     * starts as a thread, this method is executed.
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread1 is running iteration " + i);
        }
    }

}
