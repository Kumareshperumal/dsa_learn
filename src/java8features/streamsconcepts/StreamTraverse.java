package java8features.streamsconcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

    /*
         Note that, similarly to iterators, a stream can be traversed only once.
         After that a stream is said to be consumed.
         You can get a new stream from the initial data source to traverse it again
         just like for an iterator (assuming it’s a repeatable source like a collection;
         if it’s an I/O channel, you’re out of luck).
         For example, the following code would throw an exception indicating the stream has been consumed:
         */
public class StreamTraverse {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java", "in", "Action");
        Stream<String> streamList = title.stream();
        streamList.forEach(System.out::println);
        streamList.forEach(System.out::println);
    }
}
