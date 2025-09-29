package recursion;

import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {
        fibonacciNum(4);
    }

    private static void fibonacciNum(int i) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        long startTime = System.currentTimeMillis();
        int result = fibonacciNum(4, memo);
        System.out.println("fibonacci of 444 ? " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time ? " + (endTime - startTime));
        System.out.println(memo);
        memo.entrySet().forEach(a -> System.out.print(a.getValue() + " "));
    }

    private static int fibonacciNum(int num, HashMap<Integer, Integer> memo) {
        if (num <= 2) return 1;
        else if (memo.containsKey(num)) return memo.get(num);
        else {
            int result = fibonacciNum(num - 1, memo) + fibonacciNum(num - 2, memo);
            memo.put(num, result);
            return result;
        }

    }
}
