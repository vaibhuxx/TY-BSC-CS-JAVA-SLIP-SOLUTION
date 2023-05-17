import java.util.Random;

 

public class Slip13b implements Runnable {

 

    private String threadName;

 

    public Slip13b(String threadName) {

        this.threadName = threadName;

    }

 

    @Override

    public void run() {

        // Thread creation

        System.out.println("Thread " + threadName + " created.");

 

        // Randomly sleep for 0 to 4999 milliseconds

        Random rand = new Random();

        int sleepTime = rand.nextInt(5000);

        System.out.println("Thread " + threadName + " sleeping for " + sleepTime + " milliseconds...");

        try {

            Thread.sleep(sleepTime);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

 

        // Thread dead

        System.out.println("Thread " + threadName + " is dead.");

    }

 

    public static void main(String[] args) {

        Slip13b thread1 = new Slip13b("Thread 1");

       Slip13b  thread2 = new Slip13b("Thread 2");

     Slip13b thread3 = new Slip13b("Thread 3");

 

        // Start threads

        Thread t1 = new Thread(thread1);

        Thread t2 = new Thread(thread2);

        Thread t3 = new Thread(thread3);

        t1.start();

        t2.start();

        t3.start();

    }

}