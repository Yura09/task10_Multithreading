package criticalsections;

import java.time.LocalDateTime;

public class CriticalClass {
    private static final Object object = new Object();
    private static final Object anotherObject = new Object();
    private static final Object anotherObject1 = new Object();
    private static int count = 0;

    void method1() {
        synchronized (object) {
            for (int i = 0; i < 100000; i++) {
                count++;

            }
            System.out.println(count + " " + Thread.currentThread().getName());
            System.out.println(LocalDateTime.now());
        }
    }

    void method2() {
        synchronized (object) {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
            System.out.println(count + " " + Thread.currentThread().getName());
            System.out.println(LocalDateTime.now());
        }
    }

    void method3() {
        synchronized (object) {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
            System.out.println(count + " " + Thread.currentThread().getName());
            System.out.println(LocalDateTime.now());

        }
    }

    void anotherMethod1() {
        synchronized (object) {

            System.out.println("method1" + LocalDateTime.now());
        }
    }

    void anotherMethod2() {

        synchronized (anotherObject1) {

            System.out.println("method2" + LocalDateTime.now());
        }

    }

    void anotherMethod3() {

        synchronized (anotherObject) {


            System.out.println("method3" + LocalDateTime.now());
        }
    }

}
