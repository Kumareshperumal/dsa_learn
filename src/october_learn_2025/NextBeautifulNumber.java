package october_learn_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class NextBeautifulNumber {
    public static void main(String[] args) {
        int n=3000;
        nBnumber(n);
        //java8 version
        nBnum(n);
    }

    private static void nBnum(int n) {
        IntStream.range(n+1, 1_000_000)
                .filter(NextBeautifulNumber::balanceNumber)
                .findFirst()
                .ifPresent(d -> System.out.println("Balanced Number using java 8? " + d));
    }

    private static int nBnumber(int n) {
        int d = 0;
        for(int i=n+1; i< 1000000;i++){
            if(balanceNumber(i)) {
                System.out.println("Balance Number ? " + i);
                d =i;
                break;
            }
        }
        return d;

    }

    private static boolean balanceNumber(int i) {
//        Map<Integer, Integer> map = new HashMap<>();
//        while(i >0){
//            int g = i % 10;
//            map.put(g, map.getOrDefault( g,0) + 1);
//            i = i / 10;
//        }
//        for (int k : map.keySet()){
//            if(k != map.get(k)) return false;
//        }
//        return true;
       Map<Integer,Long> v = String.valueOf(i)
                .chars()
                .boxed()
                .collect(HashMap::new, (map, c)-> map.merge(c-'0', 1L, Long::sum), HashMap::putAll);
        System.out.println(v);

       return v.entrySet()
               .stream()
               .allMatch(k -> k.getValue().intValue() == k.getKey());
    }
}
