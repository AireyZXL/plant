package com.resico.plant.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverDev2 {


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch doneSignal = new CountDownLatch(7);
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            executorService.submit(new WorkerRunnable(doneSignal, i));
        }

        doneSignal.await();
        System.out.println(Thread.currentThread().getName() + ": 执行主线程任务");
    }


}

class WorkerRunnable implements Runnable {


    private final CountDownLatch doneSignal;
    private final int i;

    WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        doWork(i);
        doneSignal.countDown();
    }

    private void doWork(int i) {

        System.out.println(Thread.currentThread().getName() + ":doWork()===========" + i);

    }
}
