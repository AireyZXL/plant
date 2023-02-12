package com.resico.plant.thread;

import java.util.concurrent.*;

/**
 * @author Airey
 * @date 2023/1/30 10:41
 */
public class FutureDev {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> task = new Task();

        Future<String> future = executorService.submit(task);

        String s = future.get();

        System.out.println(s);



    }


}


class Task implements Callable<String> {


    @Override
    public String call() throws Exception {
        return getName();
    }


    public String getName() {

        return "Airey";
    }
}
