package java8features.streamsconcepts;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        optional(DishMain.dishes());
    }

    private static void optional(List<Dish> dishes) {
        Optional<Dish> res = dishes.stream().filter(Dish::isVegetarian).findAny();
        if (res.isPresent()) System.out.println(res.get().getName());

        //Finding the first element.
        List<Integer> someNum = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> resultINT = someNum.stream().filter(n -> n % 2 == 0).findFirst();
        if (resultINT.isPresent()) System.out.println(resultINT.get());
        //reduce function
        int factorial = someNum.parallelStream().reduce(1, (a, b) -> a * b);
        System.out.println("factorial of integers ? " + factorial);
        int sum = someNum.parallelStream().reduce(0, Integer::sum);
        System.out.println("Sum of the given integers ? " + sum);


    }
}
