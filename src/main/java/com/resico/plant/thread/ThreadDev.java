package com.resico.plant.thread;

/**
 * @author Airey
 * @since 2022/4/21 16:44
 */
public class ThreadDev {





    public static void main(String[] args) {


        int m=1;
        int n=3;

        Integer order=2;

        System.out.println("m="+m);


        Thread thread=new Thread(()->{

            System.out.println("32424r234324");


        });

        thread.start();

        System.out.println("m+n="+m+n);

    }


}
