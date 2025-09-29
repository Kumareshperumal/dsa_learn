package java8features.functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
//        MyPrinter printer = message -> System.out.println("Message : " + message);
//        printer.print("Display Employee Documents");
        MyPrinter r = MainClass::greet;
        r.print();
        filterValidEmails();
        convertUpperCase();


    }

    public static void greet(){
        System.out.println("hello from static method!");
    }

    public static void filterValidEmails(){
        List<String> emails = List.of("test@gmail.com", "invalid", "name@domain.com");
        Predicate<String> isValidEmail = s -> s.contains("@") && s.contains(".");

        List<String> result = emails.stream()
                .filter(isValidEmail)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void convertUpperCase(){
        List<String> names = List.of("alice", "bob");
        Function<String, String> formatName = s -> "Mr." + s.toUpperCase();

        List<String> result = names.stream()
                .map(formatName)
                .collect(Collectors.toList());
        System.out.println(result); // [Mr. ALICE, Mr. BOB]

        List<Integer> nums = List.of(1, 2, 3);
        Consumer<Integer> logger = System.out::println;

        nums.forEach(logger);

        List<String> data = List.of("123", "abc", "4567");

        Predicate<String> isNumeric = d ->d.matches("\\d+");
        Function<String, Integer> toInt = Integer::parseInt;
        Consumer<Integer> doublePrinter = d -> System.out.println("Double : " + (d*2));

        data.stream()
                .filter(isNumeric)
                .map(toInt)
                .forEach(doublePrinter);
    }
}
