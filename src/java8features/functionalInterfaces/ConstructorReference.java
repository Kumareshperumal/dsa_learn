package java8features.functionalInterfaces;

import java8features.behaviorparameterization.Apple;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReference {
    public static void main(String[] args) {
        BiFunction<String,Integer,Apple> appleBiFunction = Apple::new;
        Apple c = appleBiFunction.apply("DarkRed",157);
        System.out.println(c);

        TriFunction<String,Integer,String,Fruit> fruitTriFunction = Fruit::new;
        Fruit fruit = fruitTriFunction.apply("Orange",152,"5 kg");
        System.out.println(fruit);
    }
}
