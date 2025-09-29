package september_learn;

import java.util.Arrays;

public class MaxNumberCanType {
    public static void main(String[] args) {
        String text = "leet code";
        String brokenLetters = "lt";
      int res =  canBeTypedWords(text,brokenLetters);
        System.out.println(res);
    }

    private static int canBeTypedWords(String text, String brokenLetters) {
        /*String[] data = text.split(" ");
        int count =0;
        boolean flag = false;
        System.out.println(Arrays.toString(data));
        for (String input: data){
            int pivot = 0;
            while(pivot < brokenLetters.length()){
                if(input.contains(brokenLetters.charAt(pivot)+"")){
                    flag = false;
                    break;
                }else flag=true;
                pivot++;
            }

            if(flag) count++;
        }
        System.out.println(count);*/
       int count = 1;
       boolean flag = true;
       boolean[] c = new boolean[26];
       for(int i=0; i<brokenLetters.length();i++){
           c[brokenLetters.charAt(i) - 97] = true;
       }
       for(char ch: text.toCharArray()){
           if(ch == ' '){
               flag = true;
               count++;
           }else if(c[ch - 'a'] && flag){
               count--;
               flag= false;
           }
       }
       return count < 1 ? 0 : count;
    }
}
