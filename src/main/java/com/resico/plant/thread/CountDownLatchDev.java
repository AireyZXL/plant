package com.resico.plant.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDev {


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);


        AppleRunnable appleRunnable = new AppleRunnable("Airey123", 25);
        OrangeRunnable orangeRunnable = new OrangeRunnable("Orange", 34);
        Thread appleThread = new Thread(appleRunnable);
        appleThread.start();
        countDownLatch.countDown();
        Thread orangeThread = new Thread(orangeRunnable);
        orangeThread.start();
        countDownLatch.countDown();

        try {
            Thread.sleep(3000);
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+": 打印12323421312312");

    }

}

class AppleRunnable implements Runnable {


    private String name;

    private Integer age;

    public AppleRunnable(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "==this.getName=" + name);
        age++;
        System.out.println(Thread.currentThread().getName() + "==调整后的年龄为:" + age);

    }
}


class OrangeRunnable implements Runnable {


    private String name;

    private Integer age;

    public OrangeRunnable(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "==this.getName=" + name);
        age++;
        System.out.println(Thread.currentThread().getName() + "==调整后的年龄为:" + age);

    }
}


