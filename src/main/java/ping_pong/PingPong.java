package ping_pong;

public class PingPong implements Runnable {
    private String name;
    private static final Object object = new Object();

    PingPong(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                System.out.print(name + " " + i + '\n');
                object.notify();
                try {
                    object.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

