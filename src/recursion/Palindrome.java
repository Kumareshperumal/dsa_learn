package recursion;

import java.util.Arrays;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        List<String> inputData = Arrays.asList("racecars", "madam", "step on no pets", "able was i ere i saw elba", "Q", "Java", "rotater", "byebye", "notion");
        inputData.forEach(i -> {
            boolean result = palindromeCalculation(i);
            System.out.println("Is \\" + i + "\\ a palindrome ? " + result);
        });
       boolean res = palindromeCheck("racecar");
        System.out.println("is / racecar / a Palindrome ? " + res);
        System.out.println("data".substring(1,"data".length()-1)+ ", " + "data".charAt("data".length()-1));
    }

    private static boolean palindromeCheck(String input) {
        if(input.length() <= 1) return true;
        else{
            return input.charAt(0) == input.charAt(input.length()-1) && palindromeCheck(input.substring(1,input.length()-1));
        }
    }

    private static boolean palindromeCalculation(String racecar) {
        if(racecar.length() <2)return true;
        else
            return racecar.charAt(0) == racecar.charAt(racecar.length()-1) && palindromeCalculation(racecar.substring(1,racecar.length()-1));
    }
}
