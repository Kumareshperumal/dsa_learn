package textprocessing;

import java.util.Arrays;

public class KmpAlgo {
    public static void main(String[] args) {
       boolean result = kmpAlgorithm();
        System.out.println("Kmp Algo result ? " + result);
    }

    private static boolean kmpAlgorithm() {
        String text = "abacaabccababacaabb";
        String pattern = "ababaca";
        int[] lpsArray = getLpsMatching(pattern);
        int textPointer = 0, patternPointer = 0;
        while(textPointer < text.length()){
            if(pattern.charAt(patternPointer) == text.charAt(textPointer)){
                textPointer += 1;
                patternPointer += 1;
                if(patternPointer == lpsArray.length) return true;
            }else if(patternPointer > 1){
                patternPointer = lpsArray[patternPointer-1];
            } else  textPointer += 1;
        }
        return false;
    }

    private static int[] getLpsMatching(String pattern) {
        int[] prefix = new int[pattern.length()];
        int prefixPointer = 0, patternPointer = 1;

        while(patternPointer < pattern.length()){
            if(pattern.charAt(prefixPointer) == pattern.charAt(patternPointer)){
                prefixPointer += 1;
                prefix[patternPointer] = prefixPointer;
                patternPointer += 1;
            }
            else {
                if(prefixPointer == 0){
                    patternPointer += 1;
                }else{
                    prefixPointer = prefix[prefixPointer-1];
                }

            }
        }

        System.out.println(Arrays.toString(prefix));

        return prefix;
    }
}
