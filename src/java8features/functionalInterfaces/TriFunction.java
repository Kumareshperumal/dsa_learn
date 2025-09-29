package java8features.functionalInterfaces;
@FunctionalInterface
public interface TriFunction<T,V,U,R> {
    R apply(T t, V v, U u);
}
