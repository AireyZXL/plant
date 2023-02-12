package com.resico.plant.mode.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Airey
 * @date 2023/1/13 17:37
 */
public class Singleton1 {


    private Singleton1() {

    }

    private final static Singleton1 INSTANCE = new Singleton1();


    public Singleton1 getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);




    }



}
