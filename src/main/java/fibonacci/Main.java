package fibonacci;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 10; i < 20; i++) {
            Thread t = new Thread(new Fibonacci(i));
            t.start();
            t.join();
        }
    }
}
