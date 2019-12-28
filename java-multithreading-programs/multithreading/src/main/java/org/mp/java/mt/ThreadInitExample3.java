package org.mp.java.mt;

public class ThreadInitExample3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int index = 0; index < 10; index++) {
                    System.out.println("[" + this.getClass().getName() + "] - " + index);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int index = 0; index < 10; index++) {
                System.out.println("[Lambda] - " + index);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        thread1.start();
        thread2.start();
    }
}