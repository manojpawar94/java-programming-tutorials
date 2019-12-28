package org.mp.java.mt;

public class ThreadInitExample2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableClassOne());
        Thread thread2 = new Thread(new RunnableClassTwo());
        thread1.start();
        thread2.start();
    }
}

class RunnableClassOne implements Runnable {

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
}

class RunnableClassTwo implements Runnable {

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
}