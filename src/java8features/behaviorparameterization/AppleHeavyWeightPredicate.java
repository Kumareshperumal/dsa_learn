package java8features.behaviorparameterization;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return 150 < apple.getWeight();
    }
}
