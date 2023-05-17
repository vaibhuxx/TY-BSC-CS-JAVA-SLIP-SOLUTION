public class Slip6a {

    private final Object lock = new Object(); // lock object for synchronization

    private String signalColor = "red"; // start with red signal

   

    // method to change the signal color

    private void changeSignalColor(String newColor, int time) {

        System.out.println("Changing signal to " + newColor);

        try {

            Thread.sleep(time); // wait for the specified time

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        signalColor = newColor; // update signal color

    }

   

    // thread class for green signal

    private class GreenSignalThread extends Thread {

        @Override

        public void run() {

            while (true) {

                synchronized (lock) {

                    changeSignalColor("green", 10000); // change signal to green for 10 seconds

                    lock.notifyAll(); // notify other threads waiting on the lock

                    try {

                        lock.wait(); // wait for other threads to finish

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                }

            }

        }

    }

   

    // thread class for yellow signal

    private class YellowSignalThread extends Thread {

        @Override

        public void run() {

            while (true) {

                synchronized (lock) {

                    changeSignalColor("yellow", 3000); // change signal to yellow for 3 seconds

                    lock.notifyAll(); // notify other threads waiting on the lock

                    try {

                        lock.wait(); // wait for other threads to finish

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                }

            }

        }

    }

   

    // thread class for red signal

    private class RedSignalThread extends Thread {

        @Override

        public void run() {

            while (true) {

                synchronized (lock) {

                    changeSignalColor("red", 5000); // change signal to red for 5 seconds

                    lock.notifyAll(); // notify other threads waiting on the lock

                    try {

                        lock.wait(); // wait for other threads to finish

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                }

            }

        }

    }

   

    // main method to start the program

    public static void main(String[] args) {

        Slip6a trafficSignal = new Slip6a();

        Thread greenThread = trafficSignal.new GreenSignalThread();

        Thread yellowThread = trafficSignal.new YellowSignalThread();

        Thread redThread = trafficSignal.new RedSignalThread();

        greenThread.start();

        yellowThread.start();

        redThread.start();

    }

}

 