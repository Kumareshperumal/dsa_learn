package dynamic.programming.recursion.freecodecamp;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        fibMethod(6);
        fibMethod(8);
        fibMethod(50);
    }

    private static void fibMethod(int n) {
        long startTime = System.currentTimeMillis();
        long[] fib = new long[n + 1];
        fib[1] = 1;
        for (int i = 1; i <= n; i++) {
            System.out.println(Arrays.toString(fib));
            if ((i + 1) <= n)
                fib[i + 1] += fib[i];
            if ((i + 2) <= n)
                fib[i + 2] += fib[i];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total time ? " + (endTime - startTime));
        System.out.println(fib[n]);
    }
}
