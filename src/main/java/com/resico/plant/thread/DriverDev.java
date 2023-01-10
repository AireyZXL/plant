package com.resico.plant.thread;

import java.util.concurrent.CountDownLatch;

public class DriverDev {


    public static void main(String[] args) throws InterruptedException {


        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(7);
        for (int i = 0; i < 7; ++i) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        doSomethingElse();
        startSignal.countDown();
        doSomethingElse();
        doneSignal.await();


    }

    private static void doSomethingElse() {

        System.out.println(Thread.currentThread().getName() + ":doSomethingElse()-----------------");
    }


}

class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {

        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    void doWork() {

        System.out.println(Thread.currentThread().getName() + ":doWork+++++++++++++++");

    }


}