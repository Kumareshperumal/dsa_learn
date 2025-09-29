package august.learn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAug9 {
    public static void main(String[] args) {
        streamsOne();
        streamsTwo();
    }

    private static void streamsTwo() {
        List<Orders> orders = Arrays.asList(
                new Orders("O1", Arrays.asList("Apple", "Mouse")),
                new Orders("O2", Arrays.asList("Keyboard", "Monitor")),
                new Orders("O3", Arrays.asList("USB Cable"))
        );
        List<String> products = orders.stream().flatMap(o->o.getProducts().stream().map(String::toUpperCase)).collect(Collectors.toList());
        System.out.println(products);


    }

    private static void streamsOne() {
        List<String> words = List.of("Java8", "Lambdas", "In", "Actions");
        List<Integer> wordsLen =  words.stream().map(w -> w.length()).collect(Collectors.toList());
        System.out.println(wordsLen);

        List<String> wordsCharacter = words.stream().map(w->w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(wordsCharacter);

        List<Integer> input = List.of(1,2,3,4,5);
        List<Integer> output=  input.stream().map(i ->i*i).collect(Collectors.toList());
        System.out.println(output);

        List<Integer> input1 = List.of(1,2,3);
        List<Integer> input2 = List.of(3,4);
        List<int[]> data = input1.stream()
                .flatMap(i -> input2.stream()
                        .filter(j->(i+j)%3==0)
                        .map(k -> new int[]{i,k}))
                .collect(Collectors.toList());
        data.parallelStream().forEach(d -> System.out.println(Arrays.toString(d)));

        words.stream().filter(w->w.length() > 5).findFirst().ifPresent(d-> System.out.println(d));

        boolean matchAll = words.stream().anyMatch(d->d.length() >5);
        System.out.println("All words > 5 ? " + matchAll);

    }
}
