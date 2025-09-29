package daily_leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    public static void main(String[] args) {
        int res = longestPal("abccccdd");
        System.out.println("result of longest string length ? " + res);
    }

    private static int longestPal(String s) {
        char[] chInput = s.toCharArray();
        Set<Character> checkChar = new HashSet<>();
        int count = 0;
        for (char ch : chInput) {
            if (checkChar.contains(ch)) {
                count = count + 1;
                checkChar.remove(ch);
            } else
                checkChar.add(ch);
        }
        if (checkChar.isEmpty()) count *= 2;
        else count = (count *2) + 1;
        return count;

    }
}
