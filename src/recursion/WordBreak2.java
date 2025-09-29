package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak2 {
    public static void main(String[] args) {
        String input = "catsanddog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        wordBreak(input, wordDict);
    }

    private static void wordBreak(String input, List<String> wordDict) {
        wordBreak(input, wordDict, "");
    }

    private static void wordBreak(String input, List<String> wordDict, String word) {
        if (input.length() == 0) {
            System.out.println(word);
        } else {
            for (int i = 0; i < input.length(); i++) {
                //choose
                String input2 = input.substring(0, i + 1);
                if (wordDict.contains(input2))
                    //explore
                    wordBreak(input.substring(i + 1), wordDict, word + input2 + " ");
            }
        }

    }
}
