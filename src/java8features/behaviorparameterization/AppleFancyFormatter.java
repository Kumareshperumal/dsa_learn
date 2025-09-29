package java8features.behaviorparameterization;

public class AppleFancyFormatter implements AppleFormatter{
    @Override
    public String accept(Apple a) {
        String charac = a.getWeight() > 150 ? "Heavy" : "Light";
        return "A " + charac + " "+a.getColor()+ " apple";
    }
}
