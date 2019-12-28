package org.mp.java.mt;

import java.util.Scanner;

public class ThreadSyncExample1 {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        processor.shutdown();
        scanner.close();
    }
}

class Processor extends Thread {
    // making thread variable volatile, it won't allow to cache variable
    private volatile boolean runningFlag = true;

    @Override
    public void run() {
        while (runningFlag) {
            System.out.println("[" + this.getName() + "] Running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }

    public void shutdown() {
        this.runningFlag = false;
    }
}