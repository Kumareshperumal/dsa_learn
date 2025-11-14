package November_learn;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Lambda1 {
    public static void main(String[] args) {
        Lambda1 lambda1 = new Lambda1();
        List<String> friends = List.of("Brian", "Nate", "Neal", "RajuSun", "Sara", "Scott");
        lambda1.filters(friends);
        String startingLetter = "N";
        lambda1.pickName(friends, startingLetter);
        startingLetter = "J";
        lambda1.pickName(friends, startingLetter);
        lambda1.stringCompAndFilters(friends);
    }

    private void stringCompAndFilters(List<String> friends) {

        String i = "S00R78L";
      String s= i.chars()
                .filter(c-> !Character.isDigit(c))
                .mapToObj(d-> (char)d +"")
               .collect(Collectors.joining());
        System.out.println("Result ? "+ s);

    }

    private void pickName(List<String> friends, String startingLetter) {
        Optional<String> foundName = friends.stream()
                .filter(stringPredicateFunction.apply(startingLetter))
                .findFirst();

        String r = friends.stream().reduce("", (n1,n2) -> (n1.length() > n2.length() ? n1: n2));
        System.out.println("Max length() of friends Name : " + r);
        System.out.println("A Name starting with  " + startingLetter +" : " + foundName.orElse("No name found"));

        String r1 = friends.stream().map(String::toUpperCase)
                        .collect(Collectors.joining(", "));
        System.out.println("Using delimiter , : " + r1);

    }

    private void filters(List<String> friends) {

        //filter out names start with 'N'
        final Predicate<String> startWithN = n->n.startsWith("N");
        List< String> result = friends.stream().filter(startWithN)
                          .toList();
        System.out.println("friends Starts with N ? " + result);
        friends.stream().filter(stringPredicate("N")).forEach(System.out::println);
        String l = "N";
        Predicate<String> s = stringPredicate(l);
        l = "B";
        s = stringPredicate(l);
        System.out.println(  s.test("Brian"));
        List<String> d= friends.stream().filter(stringPredicateFunction.apply("N")).toList();
        System.out.println(d);

    }

    Predicate<String> stringPredicate(final String letter){
        return n -> n.startsWith(letter);
    };

//    final Function<String, Predicate<String>> stringPredicateFunction = (String letter) ->{
//        Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
//        return checkStarts;
//    };

    final Function<String, Predicate<String>> stringPredicateFunction = l -> n-> n.startsWith(l);
}
