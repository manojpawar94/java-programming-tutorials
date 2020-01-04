package org.mp.java.mt;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int index = 0; index < 3; index++) {
            executorService.submit(new CountDownLatchExample().new CountDownLatchThread(latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // below sysout will print when all thread count latch down to zero
        System.out.println("Application Completed");
    }

    // inner class
    class CountDownLatchThread extends Thread {
        private CountDownLatch latch;

        public CountDownLatchThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("[" + this.getName() + "] - Started...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("[" + this.getName() + "] - Completed...");
        }
    }

}