package september_learn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str= "aab";
        palindrome(str);

    }

    private static void palindrome(String str) {
        int start =0,end =0;
        palindromePartition(str, start, new ArrayList<>());

    }

    private static void palindromePartition(String str, int start, List<String> chosen) {
        System.out.println("Start = " + start+ " , chosen = " + chosen);
        if(start == str.length()) System.out.println(chosen);
        if(start > str.length()-1) return;
        for(int i = start; i<str.length();i++){
            String temp = str.substring(start, i+1);
            System.out.println("Inside for loop ? i = " + i + ", start = " + start + ", temp = " + temp + ", chosen = "+ chosen);
            if(isPalindrome(temp)){
                chosen.add(temp);
                palindromePartition(str, i+1, chosen);
                chosen.remove(chosen.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String select) {
        if(select.length()<= 1) return true;
        else return (select.charAt(0) == select.charAt(select.length()-1)) && isPalindrome(select.substring(1,select.length()-1));
    }
}
