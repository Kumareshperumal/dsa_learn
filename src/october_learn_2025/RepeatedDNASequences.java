package october_learn_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        repeatSeq(s);
    }

    private static void repeatSeq(String s) {
        Map<String, Integer> m = new TreeMap<>();
        String sb = "";
        for(int i=0; i+10<=s.length();i++){
            sb = s.substring(i, i+10);
            if(m.containsKey(sb)){
                System.out.println("Repeated DNA Sequence ? " + sb);
            }
            m.put(sb, m.getOrDefault(sb,    0) + 1);

        }
        System.out.println(m);
    }
}
