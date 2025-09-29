package august.learn;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {
        streamsBasics();
    }

    private static void streamsBasics() {
        List<String> names = Arrays.asList("Alice","Bob","Charlie","Andrew","Eve", "David");
//        names = names.stream()
//                .filter(n-> n.startsWith("A") && n.length() >3)
//                .map(String::toLowerCase)
//                .collect(Collectors.toList());
//        System.out.println(names);

        int[] a = new int[]{1,2,3};
        for(int i:a){
            System.out.println(i);
        }

        int[] ab = new int[5];
        System.out.println(ab[3]);

      Map<Integer, String> res =  names.stream().collect(Collectors.toMap(s-> s.length(), Function.identity(), (old, newVal) -> old));
        System.out.println(res);


    }
}
