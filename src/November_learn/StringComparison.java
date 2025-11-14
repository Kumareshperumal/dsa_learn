package November_learn;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;

import static java.util.stream.Collectors.*;

public class StringComparison {
    public static void main(String[] args) throws IOException {
        List<Person> personList = List.of(new Person("John", 20),
                new Person("Sara", 23),
                new Person("Jane", 29),
                new Person("Greg", 35),
                new Person("Maverick", 23));
        comparison(personList);
        StringComparison sc = new StringComparison();
        sc.olderThan20(personList);

        Files.newDirectoryStream(Path.of("/Users/kumareshperumal/Documents/GitHub/dsa_learn/src/algorithms"), path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);

        final String[] files = new File("/Users/kumareshperumal/Documents/GitHub/dsa_learn/src/algorithms").list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        System.out.println(Arrays.toString(files));
    }


    private void olderThan20(List<Person> personList) {
        final Function<Integer, Predicate<Person>> ot20 = ageLimit-> p-> (p.getAge() > ageLimit);

         List<Person> persons = personList.stream()
                .filter(ot20.apply(20))
                .toList();

        System.out.println("Age is greater than 20  : " + persons);

      Map<Integer,List<Person>> mapByAge =  personList.stream()
                .collect(groupingBy(Person::getAge));
        System.out.println("Map by age : " + mapByAge);

        Map<Integer,List<String>> mapByAges = personList.stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getName, toList())));
        System.out.println("Map by Age : " + mapByAges);

       Comparator<Person> byAge=  Comparator.comparing(Person::getAge);

        Map<Character, Optional<Person>> mapByChar = personList.stream()
                .collect(groupingBy(t -> t.getName().charAt(0),reducing(BinaryOperator.maxBy(byAge))));
        System.out.println(mapByChar);

        Map<Character, Person> mapByChars = new HashMap<>();
        personList.forEach(p->{
            mapByChars.merge(p.getName().charAt(0),
                    p,
                    (p1,p2) -> p1.getAge() > p2.getAge() ? p1 :p2);
        });

        System.out.println("Map by chars : " + mapByChars);

       Map<Character, Person> charByPerson =  personList.stream().collect(toMap(p-> p.getName().charAt(0),
                p->p,
                (p1,p2)-> p1.getAge() > p2.getAge() ? p1: p2));
        System.out.println("Map by Char - Person :: " + charByPerson);
    }

    private static void comparison(List<Person> personList) {
        final Function<Person, String> personName = Person::getName;
        final Function<Person,Integer> personAge = Person::getAge;

        List<Person> d = personList.stream()
                .sorted(Comparator.comparing(personName))
                .toList();
        System.out.println(d);

        List<Person> ageByDes = personList.stream()
                .sorted(Comparator.comparing(personAge).reversed())
                .collect(toList());

        System.out.println(ageByDes);

    }
}
