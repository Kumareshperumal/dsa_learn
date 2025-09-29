package java8features.streamsconcepts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.stream.Collectors.*;

public class DishMain {

    public static List<Dish> dishes() {
        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        return menu;
    }

    public static void main(String[] args) {

        /*
            No result is produced, indeed no element from the menu is even selected until the collect method is invoked.
         */

        /*
            up until collect method the return type is always stream.
            Collect converts stream into another form. In this case, it converts the stream into List().
            As a result, Stream pipeline has a more flexibility to decide how to optimize this pipeline.
         */
        List<Dish> menu = dishes();
        List<String> threeHighCalorieDishes =
                menu.stream()
                        .filter(d -> d.getCalories() > 400)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());

        long count = menu.stream().filter(d -> d.getCalories() > 350).distinct().count();
        System.out.println("menu items calorie > 350 ? " + count);

        System.out.println("threeHighCalorieDishes ? " + threeHighCalorieDishes);
        int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("Total Calories ? " + totalCalories);
        groupingByConcepts(dishes());
    }

    private static void groupingByConcepts(List<Dish> menu) {
        //Group by dish type
        Map<Dish.Type, List<Dish>> dishes = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishes);

        //Group by Dish type -  counting data by type
        Map<Dish.Type, Long> dishesTypeByCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(dishesTypeByCount);

        //Group by Dish type - list name by type
        Map<Dish.Type, List<String>> dishesByNames = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println(dishesByNames);

        //Group by Dish type - summing the calories in each type.
        Map<Dish.Type,Double> dishByCalories = menu.stream().collect(groupingBy(Dish::getType,summingDouble(Dish::getCalories)));
        System.out.println(dishByCalories);

       Map<Dish.Type, Map<String, List<Dish>>> mapDishes =  menu.stream().collect(groupingBy(Dish::getType, groupingBy(Dish::getName)));
       System.out.println(mapDishes);

        String yourDateString = "2025-07-25";
        String formatted = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.parse(yourDateString));
        System.out.println(formatted);
    }
}
