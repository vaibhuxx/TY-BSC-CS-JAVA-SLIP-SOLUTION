import java.util.LinkedList;

import java.util.Queue;

 

public class Slip21 {

    public static void main(String[] args) {

        Queue<Integer> buffer = new LinkedList<>();

        int maxSize = 10;

 

        Thread producerThread = new Thread(new Producer(buffer, maxSize));

        Thread consumerThread = new Thread(new Consumer(buffer));

 

        producerThread.start();

        consumerThread.start();

    }

 

    static class Producer implements Runnable {

        private final Queue<Integer> buffer;

        private final int maxSize;

 

        public Producer(Queue<Integer> buffer, int maxSize) {

            this.buffer = buffer;

            this.maxSize = maxSize;

        }

 

        @Override

        public void run() {

            int i = 0;

            while (true) {

                synchronized (buffer) {

                    if (buffer.size() == maxSize) {

                        try {

                            buffer.wait();

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }

                    }

 

                    System.out.println("Producing value: " + i);

                    buffer.offer(i++);

                    buffer.notifyAll();

                }

            }

        }

    }

 

    static class Consumer implements Runnable {

        private final Queue<Integer> buffer;

 

        public Consumer(Queue<Integer> buffer) {

            this.buffer = buffer;

        }

 

        @Override

        public void run() {

            while (true) {

                synchronized (buffer) {

                    if (buffer.isEmpty()) {

                        try {

                            buffer.wait();

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }

                    }

 

                    int value = buffer.poll();

                    System.out.println("Consuming value: " + value);

                    buffer.notifyAll();

                }

            }

        }

    }

}