package leetcode;

import java.util.Arrays;

public class CountOccurence {
    public static void main(String[] args) {
        String str = "aabbcccdeeeeeaa";
        countOcc(str);
    }

    private static void countOcc(String str) {
        int[] ch = new int[26];
        String output = "";
        for(char ch1 : str.toCharArray()){
            ch[ch1-'a']++;
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]>0){
                output += Character.valueOf((char) (i+97))+""+ ch[i];
            }
        }
        System.out.println(Arrays.toString(ch));
        System.out.println("output ? " + output);
    }
}
