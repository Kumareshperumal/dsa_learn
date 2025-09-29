package september_learn;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        char[][] input = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word= "SEE";
        boolean res = searchword(input,word);
        System.out.println(res);
    }

    private static boolean searchword(char[][] input, String word) {
        int pivot = 0, r=0, c=0;
        boolean flag = false;
        for(int row=0;row<input.length;row++){
            for(int col = 0; col < input[0].length;col++){
                if(recursionWordSearch(input, word, row,col, 0)) {
                    System.out.println(Arrays.deepToString(input));
                    flag = true;
                    return true;
//                    break;
                }
//                if(flag) break;
            }
        }
        System.out.println("word : " + word + " , pivot " +pivot+ " row and col : " + r +", " + c);
        return false;


    }

    private static boolean recursionWordSearch(char[][] input, String word, int r, int c, int pivot) {
        if(r >= input.length || c >= input[0].length || r <0 || c < 0)
            return false;
        if(pivot == word.length()) {
            System.out.println("word found");
            return true;
        }
        if(word.charAt(pivot) != input[r][c]) return false;
        char temp = input[r][c] ;
        input[r][c] = '#';
        boolean dataFound = recursionWordSearch(input,word,r+1,c,pivot+1) ||
                        recursionWordSearch(input,word,r-1, c,pivot+1)||
                recursionWordSearch(input,word,r,c-1,pivot+1) ||
                recursionWordSearch(input,word,r,c+1,pivot+1);
        input[r][c] = temp;

        return dataFound;
    }
}
