package recursion;

import java.util.*;

public class Permute {
    public static void main(String[] args) {
        String s = "GOOGLE";
        Set<String> res = permutation(s);
        System.out.println("permutation ? " + res);
        List<Character> input = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        permuteChar(input);

    }

    private static void permuteChar(List<Character> input) {
        List chosen = new ArrayList<>();
        permuteChar(input, chosen);
    }

    public static String recursionIndent(int size){
        String str = "";
        for(int i=0;i<=size;i++){
            str += "    "+str;
        }
        return str;
    }

    private static void permuteChar(List<Character> input, List<Character> chosen) {

        System.out.println( recursionIndent(input.size())+" size ? : " + input.size()+ " , input ? :: " + input + ", chosen ?  :: "+ chosen);
        for (int i = 0; i < input.size(); i++) {
            char choose = input.remove(i);
            chosen.add(choose);
            if (input.isEmpty()) System.out.println(chosen);
            else
                permuteChar(input, chosen);
            chosen.remove(chosen.size() - 1);
            input.add(i, choose);

        }
    }

    private static Set<String> permutation(String s) {
        Set<String> result = new HashSet<>();
        //digits represent how many char needs to be printed.
        permutation(s, "", result, 3);
        return result;
    }

    private static void permutation(String s, String prefix, Set<String> result, int digits) {
        if (digits == 0) result.add(prefix);
        else {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i); // choose the first letter
                String s2 = s.substring(0, i) + s.substring(i + 1); // explore the rest of the letters.
                permutation(s2, prefix + ch, result, digits - 1);
            }
        }
    }
}
