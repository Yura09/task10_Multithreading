package ping_pong;

public class Example {

    public static void main(String[] args) {
        Thread pingThread = new Thread(new PingPong("ping"));
        Thread pongThread = new Thread(new PingPong("pong"));
        pingThread.start();
        pongThread.start();
        try {
            pingThread.join();
            pongThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class PingPong implements Runnable {
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

