package java8features.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainPredicate {

    public static void main(String[] args) {
        String s1 = "test";
        Predicate<String> str = s-> !s.isEmpty();
        boolean result = str.test(s1);
        System.out.println(result);

        List<String> names = Arrays.asList("Jack", "Jill", "Tom", "Jerry");
        Predicate<String> startsWithJandLong = name -> name.startsWith("J") && name.length() > 3;
        List<String> listJNames =  names.stream()
                .filter(startsWithJandLong)
                .collect(Collectors.toList());
        System.out.println(listJNames);

        //loop
        for(String name: names)
        {
            if(name.startsWith("J")){
                System.out.println(name.toUpperCase());
            }
        }
        System.out.println("Using streams to print uppercase letters starts with J");
        //convert the above loop into stream
        names.stream()
                .filter(n -> n.startsWith("J"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
