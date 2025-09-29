package slidingwindow;

public class SubstringBudget {
    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        equalSubstring(s, t, maxCost);
    }

    private static void equalSubstring(String s, String t, int maxCost) {
        int left =0, maxLengthLetters = 0, currCost = 0;
        for(int right =0; right<s.length();right++){
            currCost += Math.abs(s.charAt(right) - t.charAt(right));
            while (currCost > maxCost){
                currCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLengthLetters = Math.max(maxLengthLetters, right-left+1);
        }
        System.out.println(maxLengthLetters);
    }
}
