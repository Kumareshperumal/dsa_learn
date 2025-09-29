package java8features.functionalInterfaces;

import java.util.function.Function;

public class Letters {

    public static String addHeaders(String text) {
        return "From Raul, Mario and Alan : " + text;
    }

    public static String addFooters(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("lamba", "lambda");
    }

    public static void main(String[] args) {
        Function<String, String> addHeader = Letters::addHeaders;
        Function<String, String> addTransformation = addHeader.andThen(Letters::checkSpelling).andThen(Letters::addFooters);
        String result = addTransformation.apply("find the lamba");
        System.out.println("result ? " + result);
    }
}
