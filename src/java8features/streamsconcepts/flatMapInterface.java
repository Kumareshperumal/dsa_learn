package java8features.streamsconcepts;

import java.util.function.IntFunction;
import java.util.stream.Stream;

public interface flatMapInterface<U> {
    Stream<U> flatMapToObj(IntFunction<? extends Stream<? extends U>> mapper);
}
