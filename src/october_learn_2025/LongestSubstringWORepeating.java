package october_learn_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWORepeating {
    public static void main(String[] args) {
        String s = "pwwkew";
        lswor(s);
    }

    private static void lswor(String s) {
        int  max = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();

        if(s.length() <= 1) {
            max = s.length();
        }else{
            map.put(s.charAt(0), 0);
        }

        for(int i=1; i< s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= start){
                start = map.get(c)+1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-start+1);
        }



        System.out.println("Total count of non repeating string "+ max);

    }
}
