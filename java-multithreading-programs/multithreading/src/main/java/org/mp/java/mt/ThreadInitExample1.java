package org.mp.java.mt;

public class ThreadInitExample1 {

    public static void main(String[] args) {
        ThreadClass thread1 = new ThreadClass();
        ThreadClass thread2 = new ThreadClass();
        thread1.start();
        thread2.start();
        System.out.println("Completed");
    }
}

class ThreadClass extends Thread {
    @Override
    public void run() {
        for (int index = 0; index < 10; index++) {
            System.out.println("[" + this.getName() + "] - " + index);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}