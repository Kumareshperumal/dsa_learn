package java8features.functionalInterfaces;

import java.util.function.Consumer;

public class MainConsumer {
    public static void main(String[] args) {
        Consumer<String> str = (s) -> System.out.println("input string length ? " + s.length());
        str.accept("Consumer data");

    }
}
