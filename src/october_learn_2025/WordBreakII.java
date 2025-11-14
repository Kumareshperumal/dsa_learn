package october_learn_2025;

import java.util.*;

public class WordBreakII {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat","cats","and","sand","dog");
        wordBk(s, dict);
    }

    private static void wordBk(String s, List<String> dict) {
        int start = 0;
        List<String> c;
        Map<Integer, List<String>> map = new HashMap<>();
        c = wbIIHelper(s, start, dict, map);
        System.out.println(c);
    }

    //Recursion with memo.
    private static List<String> wbIIHelper(String s, int start, List<String> dict, Map<Integer, List<String>> map) {

        if(map.containsKey(start)) {
           return map.get(start);
        }

        List<String> c = new ArrayList<>();
        if(start == s.length()){
            c.add("");
            return c;
        }

        for(int i = start; i< s.length();i++){

            String temp = s.substring(start, i+1);
            if(dict.contains(temp)){
                List<String> r = wbIIHelper(s,i+1,dict,map);
                for(String sub: r){
                    String space = sub.isEmpty() ? "": " ";
                    c.add(temp + space +sub);
                }
            }

        }
        map.put(start, c);
        return c;
    }

    //Recursion - way
    private void wbHelper(String s, List<String> wordDict, int start, String t, String a, List<String> c)
    {
        if(start == s.length()){
            a = a.trim();
            c.add(a);
            return;
        }
        for(int i=start; i< s.length(); i++){
            t+= s.charAt(i)+"";
            if(wordDict.contains(t)){
                wbHelper(s,wordDict, i+1, "", a+t+" ", c);
            }
        }
    }
}
