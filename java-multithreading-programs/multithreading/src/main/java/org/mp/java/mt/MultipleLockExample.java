package org.mp.java.mt;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLockExample {

    private Object lockOne = new Object();
    private Object lockTwo = new Object();

    List<Integer> listOne = new ArrayList<>();
    List<Integer> listTwo = new ArrayList<>();

    public void stageOne() {
        synchronized (lockOne) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listOne.add(new Random().nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized (lockTwo) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listTwo.add(new Random().nextInt(100));
        }
    }

    public static void main(String[] args) {
        MultipleLockExample app = new MultipleLockExample();
        Thread thread1 = new Thread(() -> {
            for (int index = 0; index < 1000; index++) {
                app.stageOne();
                app.stageTwo();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int index = 0; index < 1000; index++) {
                app.stageOne();
                app.stageTwo();
            }
        });

        Instant startInstant = Instant.now();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant endInstant = Instant.now();
        System.out.println("Time taken: " + (Duration.between(startInstant, endInstant).toMillis()));
        System.out.println("No of items in list1: " + app.listOne.size());
        System.out.println("No of items in list2: " + app.listTwo.size());
    }
}