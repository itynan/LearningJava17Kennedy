package concurrency.executor_service;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> future =  es.submit(() -> 3 + 4);

        try{
            System.out.println("The answer is " + future.get(500, TimeUnit.MILLISECONDS));
        }catch (InterruptedException | ExecutionException | TimeoutException ex){
            ex.printStackTrace();
        }
        es.shutdown();
    }
}
