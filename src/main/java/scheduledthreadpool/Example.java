package scheduledthreadpool;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter quantity of threads");
        int quantity = scanner.nextInt();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(quantity);
        for (int i = 0; i < quantity; i++) {
            try {
                executor.submit(new MySchedule()).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
