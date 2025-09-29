package neetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String s="anagram", t = "nagaram";
        anagramSol(s,t);
        s = "car";
        t = "rat";
        anagramSol(s,t);
    }

    private static void anagramSol(String s, String t) {

        Map<Character,Integer> countS = new HashMap<>();
        for(char c : s.toCharArray()){
            countS.computeIfPresent(c,(key, value) -> value+1);
            countS.putIfAbsent(c, 1);
        }
        System.out.println(countS);
        if(s.length() != t.length()) return;
        System.out.println("length are same!");
        for(char c1: t.toCharArray()){
            countS.computeIfPresent(c1,(key,value) -> value -1);
        }
        System.out.println(countS);
        boolean allZero = countS.values().stream().allMatch(value -> value ==0);
        if(allZero) System.out.println("This is Anagram!!");
        else System.out.println("This is not an Anagram!!");

    }
}
