package scheduledthreadpool;

import java.util.Random;
import java.util.concurrent.Callable;

public class MySchedule implements Callable {
    @Override
    public Integer call() {
        Random random = new Random();
        int secondsToSleep = random.nextInt(10) + 1;
        try {
            Thread.sleep(secondsToSleep * 1000);
            System.out.println("time of sleeping: " + secondsToSleep + "s");
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return secondsToSleep;
    }
}
