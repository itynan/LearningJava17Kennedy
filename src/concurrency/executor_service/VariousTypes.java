package concurrency.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VariousTypes {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Thread COUNT: " + threadCount);
        ExecutorService es2 = Executors.newFixedThreadPool(threadCount);

        ExecutorService es3 = Executors.newSingleThreadExecutor();
    }
}
