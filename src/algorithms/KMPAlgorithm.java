package algorithms;

import java.util.Arrays;

public class KMPAlgorithm {
    //The Knuth-Morris-Pratt (or “KMP”) algorithm

    public static void main(String[] args) {
        String pattern = "abacab";
        String data = "abacaabaccabacabaabb";
//       int res = findKmp(pattern, data);
        int res = kmpAlg(pattern,data);
        System.out.println("Result Index ? "+ res);
        System.out.println("Actual result pattern match ? " + data.substring(res, pattern.length()+res));

    }

    private static int kmpAlg(String pattern, String data) {
        int patternPointer =0, dataPointer = 0;
        int[] kmp = findKmp(pattern);
        System.out.println(Arrays.toString(kmp));
        while(dataPointer < data.length()){
            if(pattern.charAt(patternPointer) == data.charAt(dataPointer)){
                if(pattern.length()-1 == patternPointer) return dataPointer-patternPointer;
                patternPointer++;
                dataPointer++;
            }else if(patternPointer > 0) patternPointer = kmp[patternPointer-1];
            else dataPointer++;
        }
        return -1;
    }

    private static int[] findKmp(String pattern){
        int[] kmpPattern = new int[pattern.length()];
        int prefix =0, start = 1;

        while(start < pattern.length()){
            if(pattern.charAt(prefix) == pattern.charAt(start)){
                kmpPattern[start] = prefix+1;
                prefix++;
                start++;
            }
            else if(prefix > 0) prefix = kmpPattern[prefix-1];
            else start++;
        }
        return kmpPattern;

    }

    /*private static int findKmp(String pattern, String data) {
        int dataLength = data.length();
        int patternLength = pattern.length();
        if(patternLength == 0) return 0;
        int[] patternArr = kmpPattern(pattern);
        System.out.println(Arrays.toString(patternArr));
        int start = 0;
        int prefix = 0;
        char[] dataArr = data.toCharArray();
        char[] pattArr=pattern.toCharArray();
        while(start < dataLength) {
            if (dataArr[start] == pattArr[prefix]) {
                if (prefix == patternLength - 1) return start - patternLength + 1;
                start++;
                prefix++;
            } else if (prefix > 0) prefix = patternArr[prefix - 1];
            else start++;
        }
        return  -1;
    }*/

   /* private static int[] kmpPattern(String pattern) {
        char[] patternChar = pattern.toCharArray();
        int patternLength = patternChar.length;
        int prefix = 0;
        int start = 1;
        int[] patternIndex = new int[patternLength];
        while(start < patternLength){
            if(patternChar[start] == patternChar[prefix]){
                patternIndex[start] = prefix + 1;
                start++;
                prefix++;
            } else if(prefix > 0) prefix = patternIndex[prefix-1];
            else start++;
        }
        return patternIndex;
    }*/
}
