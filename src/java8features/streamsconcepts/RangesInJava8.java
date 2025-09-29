package java8features.streamsconcepts;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class RangesInJava8 {
    public static void main(String[] args) {
        IntStream oddNumber = IntStream.rangeClosed(0, 100).filter(i -> i % 2 == 1);
        System.out.println("Total odd number count? " + oddNumber.count());
        generatingTuple();
        Stream<String> stream = Stream.of("Java8", "Lambda", "in", "Actions");
        stream.map(String::toUpperCase).forEach(System.out::println);
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int sum = Arrays.stream(numbers).map(n -> n * n).sum();
        System.out.println("Sum of Square of int range from 1 to 5 ?" + sum);
    }

    private static void generatingTuple() {
        Stream<double[]> pythogoreanTuple = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));
        System.out.println("Pythogorean answer ? ");
        pythogoreanTuple.limit(5).forEach(p -> System.out.println(p[0] + ", " + p[1] + ", " + p[2]));
    }
}
