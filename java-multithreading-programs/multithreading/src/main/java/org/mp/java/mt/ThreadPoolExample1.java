package org.mp.java.mt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int index = 0; index < 10; index++) {
            executorService.submit(new ProcessThread(index));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ProcessThread extends Thread {
    private int jobNumber;

    public ProcessThread(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    @Override
    public void run() {
        System.out.println("[" + this.getName() + "] Started Executing Job Number : " + jobNumber);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + this.getName() + "] Completed Execution of Job Number : " + jobNumber);
    }

}