package org.mp.java.mt;

public class ThreadSyncExample2 {
    private int count = 0;

    public static void main(String[] args) {
        ThreadSyncExample2 app = new ThreadSyncExample2();
        app.doWork();
    }

    public void doWork() {
        Thread thread1 = new Thread(() -> {
            for (int index = 0; index < 10000; index++) {
                this.increament();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int index = 0; index < 10000; index++) {
                this.increament();
            }
        });

        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count: " + count);
    }

    // create intrinsic lock on the method, so one thread only can access at time
    public synchronized void increament() {
        this.count++;
    }

}