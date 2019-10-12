package fibonacci;

import java.util.concurrent.*;

public class ExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            for (int i = 4; i < 8; i++) {
                new Fibonacci(i).run();
            }
        });
        executor.shutdown();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        TimeUnit.SECONDS.sleep(1);
        Future<Long> future = executorService.submit(new Fibonacci(5).new FibonacciCall());
        Future<Long> future1 = executorService.submit(new Fibonacci(10).new FibonacciCall());
        System.out.println("sum: " + future.get());
        System.out.println("sum: " + future1.get());
        executorService.shutdown();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Fibonacci fibonacci = new Fibonacci(6);
        scheduledExecutorService.schedule(fibonacci, 3, TimeUnit.SECONDS);
        System.out.println();
        scheduledExecutorService.scheduleWithFixedDelay(fibonacci, 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.awaitTermination(4, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
        boolean terminated = scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);

        if (terminated) {
            System.out.println("The executor was successfully stopped");
        } else {
            System.out.println("Timeout elapsed before termination");
        }
    }
}
