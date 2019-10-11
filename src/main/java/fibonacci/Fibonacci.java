package fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Fibonacci implements Runnable {
    private int n;
    private List<Long> listOfFibonacciNumbers;

    Fibonacci(int n) {
        this.n = n;
        listOfFibonacciNumbers = new LinkedList<>();
    }

    private void buildFibonacci() {

        long t1 = 0;
        long t2 = 1;
        for (int i = 1; i <= n; ++i) {
            listOfFibonacciNumbers.add(t1);
            long sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }

    }

    private long getSumOfFibonacciNumbers() {
        return listOfFibonacciNumbers.stream().mapToLong(Long::longValue).sum();
    }

    @Override
    public void run() {

        buildFibonacci();
        System.out.println(listOfFibonacciNumbers);
        System.out.println("sum: " + getSumOfFibonacciNumbers() + "  " + Thread.currentThread().getName());


    }
}
