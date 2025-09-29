package daily_leetcode;

public class CharSubstring {
    public static void main(String[] args) {
        String s = "z";
        String t = "abcde";
        int res = appendChar(s, t);
        System.out.println(res);
    }

    private static int appendChar(String s, String t) {
        int sLen = 0;
        int tLen = 0;
        while (sLen < s.length()) {
            if (s.charAt(sLen) == t.charAt(tLen)) {
                tLen++;
            }
            if(tLen >= t.length()) break;
            sLen++;
        }
        if(tLen >= t.length()) return 0;
        int length = t.length() - tLen;
        return length;
    }
}
