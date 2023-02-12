package com.resico.plant.thread;

public class ThreadVisibilityDev {


    public long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }




    public static void main(String[] args) throws InterruptedException {

    }




}
