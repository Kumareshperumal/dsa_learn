package java8features.behaviorparameterization;

public class AppleGreenColorPredicate implements  ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "green".equalsIgnoreCase(apple.getColor());
    }
}
