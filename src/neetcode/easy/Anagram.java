package neetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        System.out.println("Input1: anagram &&&& Input2 : nagaram ::::");
        String s="anagram", t = "nagaram";
        anagramSol(s,t);
        s = "car";
        t = "rat";
        System.out.println("Input1 : car &&&& Input2 : rat ::::");
        anagramSol(s,t);
    }

    private static void anagramSol(String s, String t) {

        Map<Character,Integer> countS = new HashMap<>();
        for(char c : s.toCharArray()){
            countS.put(c, countS.getOrDefault(c, 0)+1);
        }
        System.out.println(countS);
        if(s.length() != t.length()) return;
        System.out.println("length are same!");
        for(char c1: t.toCharArray()){
            countS.put(c1, countS.getOrDefault(c1,0)-1);
        }
        System.out.println(countS);
        boolean allZero = countS.values().stream().allMatch(value -> value ==0);
       boolean isZero = countS.values().stream().anyMatch(v -> v != 0);
        if(allZero) System.out.println("This is Anagram!!");
        else System.out.println("This is not an Anagram!!");
        System.out.println("Is this Anagram ? " + !isZero);

    }
}
