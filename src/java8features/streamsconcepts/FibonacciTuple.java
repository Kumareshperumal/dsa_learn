package java8features.streamsconcepts;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciTuple {
    public static void main(String[] args) {
        fibonacci();
        factorial();
    }

    private static void factorial() {
        int fact = IntStream.rangeClosed(1, 50).limit(6).reduce(1, (a, b) -> a * b);
        System.out.println("*****************************");
        System.out.println("factorial ? " + fact);
    }

    private static void fibonacci() {
        Stream<int[]> fib = Stream
                .iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]});
        fib.limit(10)
                .map(f -> f[0])
                .forEach(System.out::println);
    }
}
