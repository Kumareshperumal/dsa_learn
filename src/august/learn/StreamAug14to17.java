package august.learn;

import java8features.streamsconcepts.Dish;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java8features.streamsconcepts.DishMain.dishes;

public class StreamAug14to17 {

    public static void main(String[] args) {
        streamOne();
        streamTwo();
        StreamGroupingBy();
        StreamPartitionBy();
        List<Integer> test = List.of(1,2,3,4);
        for(int i =1;i<test.size();i++){
            System.out.println(test.get(i));
        }

        String data = "two1";

    }

    private static void StreamPartitionBy() {
        int n = 28;
       Map<Boolean, List<Integer>> primeData = IntStream.rangeClosed(2,n)
                .boxed()
                .collect(Collectors.partitioningBy(d -> isPrime(d)));
        System.out.println(primeData);
    }

    private static boolean isPrime(int candidate) {
        int sqrtInput = (int)Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2,sqrtInput)
                .noneMatch(n -> candidate % n == 0);
    }

    private static void StreamGroupingBy() {
        List<Dish> dishList = dishes();
       Map<CalorieLevel, List<Dish>> calorieLevelListMap =  dishList.stream().collect(groupingBy(dish ->
                dish.getCalories() <= 400 ? CalorieLevel.DIET
                        : dish.getCalories() <= 700 ?
                        CalorieLevel.NORMAL : CalorieLevel.FAT));
        System.out.println("map using calorieLevel ? ");
        System.out.println(calorieLevelListMap);

       Map<Dish.Type, Map<CalorieLevel, List<Dish>>> multiLevelMapDish = dishList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> dish.getCalories() <= 400 ?
                CalorieLevel.DIET : dish.getCalories() <= 700 ? CalorieLevel.NORMAL : CalorieLevel.FAT)));
        System.out.println(multiLevelMapDish);

        Map<Dish.Type, Long> dishCount = dishList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println("Count by dishType ? " + dishCount);
        Collector<Dish, ?, Dish> dishCollectors =  collectingAndThen(
                maxBy(Comparator.comparing(Dish::getCalories)),
                Optional::get);

        Map<Dish.Type, Dish> maxByCalorieDish = dishList.stream()
                .collect(Collectors.groupingBy(Dish::getType,dishCollectors));

        System.out.println("dishCollectors ? " + dishCollectors);
        System.out.println("Max calorie dish by Type ? " + maxByCalorieDish);


    }

    private static void streamTwo() {
//        fibonacciTuple
        System.out.println("Fibonacci series : ");
       Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0]+t[1]})
               .limit(10)
               .forEach(d-> System.out.println(d[0]));
        List<Dish> dishList = dishes();

        //Reducing concept.
      String menu =  dishList.stream()
                        .map(Dish::getName)
                                .collect(reducing((s1,s2)->s1+s2)).get();

        System.out.println(menu);

        menu = dishList.stream().collect(reducing("",Dish::getName,(s1,s2) -> s1+s2));
        System.out.println(menu);

       Map<Dish.Type, String> dishs = dishList.stream().collect(groupingBy(Dish::getType,reducing("", Dish::getName, (d1,d2) -> d2)));
        System.out.println(dishs);
    }

    private static void streamOne() {
        IntStream evenNumbers = IntStream.rangeClosed(1,100).filter(e->e%2==0);
        System.out.println(evenNumbers.count());

        IntStream.rangeClosed(1,10).boxed()
                .flatMap(a-> IntStream.rangeClosed(a,20)
                        .mapToObj(b-> new double[]{a, b, Math.sqrt((a*a)+(b*b))}))
                        .filter(d-> d[2] %1 ==0)
                        .limit(3).forEach(data -> System.out.println(Arrays.toString(data)));

    }
}
