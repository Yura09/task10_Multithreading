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

