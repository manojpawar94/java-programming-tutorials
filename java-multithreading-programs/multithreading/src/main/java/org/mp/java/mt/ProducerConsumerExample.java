package org.mp.java.mt;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {

    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> {
            while (true) {
                try {
                    // if size of BlockingQueue is full it put() internally wait until size
                    // available
                    blockingQueue.put(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    if (new Random().nextInt(10) == 0) {
                        // if BlockingQueue.take() is empty then it internally wait until item is
                        // avaible
                        System.out.println("The Element for blockingQueue: " + blockingQueue.take()
                                + " | blockingQueue size: " + blockingQueue.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}