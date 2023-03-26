package concurrency.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VariousTypes {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Thread COUNT: " + threadCount);
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("Free memory (bytes): " + freeMemory);
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("total memory (bytes): " + totalMemory);
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("max memory (bytes): " + maxMemory);

        Runtime.Version runtimeVersion;
        System.out.println(Runtime.version());

        ExecutorService es2 = Executors.newFixedThreadPool(threadCount);

        ExecutorService es3 = Executors.newSingleThreadExecutor();
    }
}
