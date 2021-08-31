package igd.concurrency;

import java.util.Random;
import java.util.concurrent.*;

public class SimpleExecutorServiceDemo {

    public static void main(String[] args) {

        // To create a thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Submit task and capture placeholder in Future
        Future<Integer> future = executorService.submit(new Task());
        System.out.println("Main Thread executon in flow");

        try{
            // get the task return value;
            Integer result = future.get();
            System.out.println("Result from task :"+result);

        } catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }


    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call(){
             return new Random().nextInt();
        }

    }
}
