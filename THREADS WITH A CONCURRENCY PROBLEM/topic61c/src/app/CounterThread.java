package app;

import java.util.Random;

/**
 * A specialized Thread class that sleeps for a random duration (between 1 and 1000 milliseconds)
 * and then increments a static counter.
 */
public class CounterThread extends Thread {

    @Override
    public void run() {
        // Generate a random number between 1 and 1000
       try
       {
    	Random rand = new Random();
        int sleeper = rand.ints(1,(1000 + 1)).findFirst().getAsInt();
         // Sleep this thread for the random amount  
       Thread.sleep(sleeper);
        }
       catch (InterruptedException e) {
           
    	   e.printStackTrace();
        }

        // Increment the counter and exit this thread
        Counter.increment();
    }
}
