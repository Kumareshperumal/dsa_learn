package recursion;

import static java.lang.Character.isDigit;

public class PowerOfTwo {
    public static void main(String[] args) {
        boolean result = powerTwo(14);
        System.out.println("result ? " + result);
        System.out.println("  result  !".trim() );
        String s = "   1result    !";
        s.trim();
        String newS = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' ') continue;
            newS += s.charAt(i)+"";
        }

    }

    private static boolean powerTwo(int num) {
        if (num == 1) return true;
        else {
            return num % 2 == 0 && powerTwo(num / 2);
        }

    }


}
