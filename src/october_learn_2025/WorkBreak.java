package october_learn_2025;

import java.util.HashMap;
import java.util.Map;

public class WorkBreak {
    public static void main(String[] args) {
        String s = "catsandog";
        String[] wordDict = {"cats","dog","sand","and","cat"};
        wordBrk(s, wordDict);
    }

    private static void wordBrk(String s, String[] wordDict) {
        int pivot = 0, listIndex = 0, index = 0;
        String s1 = "";
        Map<Integer, Boolean> map = new HashMap<>();
        boolean output = wordBrkHelper(s, wordDict, 0, "", map);
        System.out.println("Is wordbreak ? " + output);
//        wordBrkHelper(s,wordDict,pivot,listIndex,s1,index);
    }

    private static void wordBrkHelper(String s, String[] wordDict, int pivot, int listIndex, String s1, int index) {
        if (s1.length() == wordDict[listIndex].length()) {
            System.out.println(wordDict[listIndex]);
            listIndex++;
            s1 = "";
            index = 0;
        }
        if (listIndex >= wordDict.length) return;
        for (int i = pivot; i < s.length(); i++) {
            s1 += s.charAt(i) + "";
            if (s1.length() <= wordDict[listIndex].length() && wordDict[listIndex].charAt(index) == s1.charAt(s1.length() - 1)) {
                wordBrkHelper(s, wordDict, i, listIndex, s1, index + 1);
            } else {
                s1 = s1.substring(0, s1.length() - 1);
            }
        }
    }

    private static boolean wordBrkHelper(String s, String[] wordDict, int start, String sentence, Map<Integer, Boolean> map) {
        if (start == s.length()) {
            System.out.println(sentence.trim());
            return true;
        }

        if (map.containsKey(start))
            return map.get(start);

        for (String word : wordDict) {
            if (s.startsWith(word, start) && wordBrkHelper(s, wordDict, start + word.length(), sentence + word + " ", map)) {
                    map.put(start, true);
                    return true;
            }
        }
        System.out.println(sentence);
        map.put(start, false);
        return false;
    }
}
