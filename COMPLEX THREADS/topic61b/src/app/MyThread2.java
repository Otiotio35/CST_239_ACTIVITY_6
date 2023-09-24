package app;

/**
 * The MyThread2 class demonstrates a simple custom thread by implementing the
 * java.lang.Runnable interface.
 *
 * @version 09/24/2023
 * @author toafik otiotio
 */
public class MyThread2 implements Runnable {

    /**
     * Default constructor for MyThread2.
     */
    public MyThread2() {
        // Default constructor logic (if any)
    }

    /**
     * The run method from the Runnable interface. When an object of MyThread2 is
     * used as a thread target, this method is executed.
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread2 is running iteration " + i);
        }
    }

}
