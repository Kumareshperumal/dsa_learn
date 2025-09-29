package java8features.streamsconcepts;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class FilteringWithStream {

    public static void main(String[] args) {
        List<Dish> menu = DishMain.dishes();
        List<Dish> vegetarianMenu = menu.stream().filter(d-> d.isVegetarian()).collect(toList());
        System.out.println("Vegetarian menu : " + vegetarianMenu);
        uniqueElements();
        limitingElements(menu);
        skippingElements(menu);
        mappingElements(menu);
    }

    private static void mappingElements(List<Dish> menu) {
        System.out.println("Dish names : ");
        List<String> names = menu.stream().map(Dish::getName).collect(toList());
        System.out.println(names);
        List<Integer> lengthOfNames = menu.parallelStream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println("Length of dish Names : " + lengthOfNames);
    }

    private static void skippingElements(List<Dish> menu) {
        /*
        Streams support the skip(n) method to return a stream that discards the first n elements.
        If the stream has fewer elements than n, then an empty stream is returned.
         */
        System.out.println("Skipping the first 3 dishes > 300 calories : ");
        menu.stream().filter(d -> d.getCalories() > 300).skip(3).forEach(System.out::println);

    }

    private static void limitingElements(List<Dish> menu) {
        System.out.println("Displaying only 3 dishes > 300 calories : ");
        menu.stream().filter(d -> d.getCalories() > 300).limit(3).forEach(System.out::println);
        System.out.println("filtering the first 2 meat dishes : ");
        List<Dish> meatDishes = menu.stream()
                .filter(d->d.getType().equals(Dish.Type.MEAT))
                .limit(2)
                .collect(toList());
        System.out.println(meatDishes);
    }

    private static void uniqueElements() {
        List<Integer> numbers = Arrays.asList(1,2,1,3,2,3,4);
        System.out.println("Printing unique values ? ");
        numbers.stream().filter(i -> i %2 ==0).distinct().forEach(System.out::println);
    }
}
