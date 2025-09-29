package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SentenceSimilarity {
    public static void main(String[] args) {
        String s2 = "My Haley";
        String s1 ="My name is Haley";
        boolean res= senSimilar(s1,s2);
        System.out.println(res);
    }

    private static boolean senSimilar(String s1, String s2) {
        Queue<String> queue = new LinkedList<>();
        String[] s2Arr = s2.split(" ");
        for(String s: s2Arr) queue.add(s);
        System.out.println(queue);
        String[] s1Arr = s1.split(" ");
        for(String check: s1Arr){
            if(!queue.isEmpty() && queue.peek().equals(check)){
                queue.poll();
            }
            else if(queue.isEmpty() && check.length() > 0){
                return false;
            }
        }
        return queue.isEmpty()? true: false;
    }
}
