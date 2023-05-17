import java.util.Random;

 

public class Slip7a implements Runnable {

    private static Random random = new Random(); // random number generator

    private static int number; // shared variable

   

    @Override

    public void run() {

        while (true) {

            try {

                Thread.sleep(1000); // wait for one second

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            synchronized (Slip7a.class) {

                number = random.nextInt(100); // generate a random number between 0 and 99

                System.out.println("Generated number: " + number);

                if (number % 2 == 0) {

                    new Thread(new SquareCalculator(number)).start(); // start a new thread to calculate square

                } else {

                    new Thread(new CubeCalculator(number)).start(); // start a new thread to calculate cube

                }

            }

        }

    }

   

    // thread class for square calculator

    private static class SquareCalculator implements Runnable {

        private int number;

       

        public SquareCalculator(int number) {

            this.number = number;

        }

       

        @Override

        public void run() {

            synchronized (Slip7a.class) {

                int square = number * number;

                System.out.println("Square of " + number + ": " + square);

            }

        }

    }

   

    // thread class for cube calculator

    private static class CubeCalculator implements Runnable {

        private int number;

       

        public CubeCalculator(int number) {

            this.number = number;

        }

       

        @Override

        public void run() {

            synchronized (Slip7a.class) {

                int cube = number * number * number;

                System.out.println("Cube of " + number + ": " + cube);

            }

        }

    }

   

    // main method to start the program

    public static void main(String[] args) {

        new Thread(new Slip7a()).start(); // start the number generator thread

    }

}