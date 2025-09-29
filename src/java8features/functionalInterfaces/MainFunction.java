package java8features.functionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainFunction {

    public static void main(String[] args) {
        Function<List<String>, Integer> function = s-> s.size();
        int result = function.apply(Arrays.asList("lambda","in","action"));
        System.out.println("output ?" + result);

        List<String> list = new ArrayList<>();
        Predicate<String> p = s -> list.add(s);
        p.test("test");
        System.out.println(list);

        Consumer<String> c = s -> list.add(s);
        c.accept("consumer");
        System.out.println(list);

       Runnable r = () -> System.out.println("Tricky example");


        map(Arrays.asList("lambda","in","actions"), s1->s1.length());
    }

    public static void map(List<String> list, Function<String ,Integer> f){
        List<Integer> result = new ArrayList<>();
        for(String s: list){
            result.add(f.apply(s));
        }
        System.out.println("output" + result);
    }
}
