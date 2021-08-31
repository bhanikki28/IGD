package igd.concurrency;

import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceDemo2 {

    public static void main(String[] args) {

        // To create a thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        //Completable Future
        // To do task in parallel

        // supplyAsync() - > thenApply(1..n ) -> thenAccept()


}
