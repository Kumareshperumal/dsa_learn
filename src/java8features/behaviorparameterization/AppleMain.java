package java8features.behaviorparameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class AppleMain {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("Green", 149),
                new Apple("Red", 169),
                new Apple("Orange", 40),
                new Apple("White", 189),
                new Apple("Blue", 201),
                new Apple("Green", 249),
                new Apple("Red", 133));
        List<Apple> data = filterApples(apples, new AppleGreenColorPredicate());
        System.out.println(data);
        prettyPrintApple(apples,new AppleFancyFormatter());
        prettyPrintApple(apples,new AppleSimpleFormatter());
        //Before Java8 using Anonymous Classes.
        prettyPrintApple(apples, new AppleFormatter() {
            @Override
            public String accept(Apple a) {
                String ch = a.getWeight() > 150 ? "Heavy" : "Light";
                return "A "+ch +" "+a.getColor()+ " apple is "+ a.getWeight()+"g.";
            }
        });
        //Using Lambda function Java8.
        prettyPrintApple(apples, apple ->  "A " + apple.getColor()+" apple of "+ apple.getWeight() + "g. ");
        apples.sort((a1,a2) -> a1.getColor().compareTo(a2.getColor()));
        apples.sort(comparing(Apple::getWeight));
        System.out.println(apples);
        apples.sort((a1,a2) -> a1.getWeight() - a2.getWeight());
        System.out.println(apples);
        List<String> stringList = Arrays.asList("Apples", "Orange", "Grapes","Mango","Pineapple");
        stringList.sort(String::compareToIgnoreCase);
        System.out.println(stringList);
        apples.sort(comparing(Apple::getColor).reversed().thenComparing(Apple::getWeight));
        System.out.println(apples);
        Predicate<Apple> a1 = ap -> ap.getColor().equalsIgnoreCase("Green");
        Predicate<Apple> a3 = a1.negate().and(a-> a.getWeight()> 150);
        List<Apple> resultCompose = filterApples1(apples,a3);
        System.out.println("resultCompose ? "+ resultCompose);

        List<Apple> redAndHeavyWeightPredicate = filterApples(apples,new AppleRedAndHeavyWeightPredicate());
        System.out.println("Red and heavy weight apples ? "+ redAndHeavyWeightPredicate);

        List<Apple> whiteApples = filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equalsIgnoreCase("White");
            }
        });
        System.out.println("White apples using Anonymous method ? " + whiteApples);

    }

    public static List<Apple> filterApples1(List<Apple> apples, Predicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : apples) {
            /* The predicate object encapsulates the condition
            to test on an apple.
             */
            if (p.test(a))
                result.add(a);
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : apples) {
            /* The predicate object encapsulates the condition
            to test on an apple.
             */
            if (p.test(a))
                result.add(a);
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> apples, AppleFormatter af){
        for (Apple a: apples){
            String output = af.accept(a);
            System.out.println(output);
        }
    }
}
