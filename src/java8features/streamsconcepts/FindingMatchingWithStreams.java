package java8features.streamsconcepts;

import java.util.List;

public class FindingMatchingWithStreams {
    public static void main(String[] args) {
        List<Dish> menu = DishMain.dishes();
        findingStreams(menu);
    }

    private static void findingStreams(List<Dish> menu) {
        if (menu.stream().anyMatch(Dish::isVegetarian))
            System.out.println("This menu is (somewhat) vegetarian friendly!");

        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println("is the dishes Healthy ? " + isHealthy);

        isHealthy = menu.stream().noneMatch(d -> d.getCalories() > 750);
        System.out.println("is the dishes are really Healthy ? " + isHealthy);
    }
}
