package java8features.behaviorparameterization;

public class AppleRedAndHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("Red") && apple.getWeight() > 150;
    }
}
