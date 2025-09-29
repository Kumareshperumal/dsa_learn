package java8features.behaviorparameterization;

public class AppleSimpleFormatter implements AppleFormatter{

    @Override
    public String accept(Apple a) {
        return "An apple of " +a.getWeight() + "g.";
    }
}
