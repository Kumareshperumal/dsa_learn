package leetcode.medium;

public class LCSAlg {

    public static void main(String[] args) {
        longestCommonSubsequence();
    }
        public static void longestCommonSubsequence() {
            String text1 = "abcede";
           String text2="xagce";
            int ans = helper(text1, text2, 0, 0);
            System.out.println(ans);
        }

    private static int helper(String text1, String text2, int i, int j) {
            if(i == text1.length() || j == text2.length()) return 0;
            if(text1.charAt(i) == text2.charAt(j)){
                return 1+helper(text1,text2,i+1,j+1);
            }
            else{
                int ans1= helper(text1,text2,i+1,j);
                int ans2 = helper(text1,text2,i,j+1);
                return Math.max(ans1,ans2);
            }

    }
}
