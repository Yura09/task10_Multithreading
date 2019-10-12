package criticalsections;

public class Example {
    public static void main(String[] args) {
        CriticalClass differentMonitors = new CriticalClass();
        Thread anotherThread = new Thread(() -> differentMonitors.anotherMethod1());
        Thread anotherThread1 = new Thread(() -> differentMonitors.anotherMethod2());
        Thread anotherThread2 = new Thread(() -> differentMonitors.anotherMethod3());
        anotherThread.start();
        anotherThread1.start();
        anotherThread2.start();
        CriticalClass oneMonitor = new CriticalClass();
        Thread thread1 = new Thread(() -> oneMonitor.method1());
        Thread thread2 = new Thread(() -> oneMonitor.method2());
        Thread thread3 = new Thread(() -> oneMonitor.method3());
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
