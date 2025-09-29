package java8features.streamsconcepts;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlatteningWithStreams {
    public static void main(String[] args) {
        flatteningStreams();
        mappingStreams();
        mappingStreams2();
    }

    private static void mappingStreams2() {
        List<Integer> n1 = Arrays.asList(1,2,3);
        List<Integer> n2 = Arrays.asList(3,4);
        System.out.println("Represent a pair of array of 2 elements ?");
        List<int[]> result = n1.stream()
                .flatMap(firstArrayOfInt -> n2.stream()
                .map(secondArrayOfInt -> new int[]{firstArrayOfInt,secondArrayOfInt})
                        .filter(s-> (s[0] + s[1]) % 3 == 0)).collect(toList());

        result.stream().forEach(d-> System.out.println(Arrays.toString(d)));

        //or The following approach
        result = n1.stream().flatMap(valueFromFirstArray-> n2.stream()
                .filter(valueFromSecondArray -> (valueFromFirstArray + valueFromSecondArray) % 3 == 0)
                .map(valueFromSecondArray -> new int[]{valueFromFirstArray,valueFromSecondArray})).collect(toList());
        System.out.println("Represent a pair of array of 2 elements using filter before map ?");
        result.stream().forEach(r-> System.out.println(Arrays.toString(r)));
    }

    private static void mappingStreams() {
        List<Integer> number = Arrays.asList(1,2,3,4,5);
        List<Integer> squares = number.stream().map(n -> n * n).collect(toList());
        System.out.println("Squares of a given "+ number + " list ? " + squares);
    }

    private static void flatteningStreams() {
        List<String> uniqueCharc = Arrays.asList("Hello", "world");
        System.out.println("Unique characters in " + uniqueCharc+ " ? ");
        uniqueCharc.stream().map(word -> word.split(""))
                //Flattened each separated stream into a single stream
                /*
                In a nutshell, the flatMap method lets you replace each value of a stream with another stream
                and then concatenates all the generated streams into a single stream.
                 */
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }
}
