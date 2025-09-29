package leetcode;

import java.util.Stack;

public class MinimumStringLength {
    public static void main(String[] args) {
        //Remove the "AB or CD" in string.
        String str = "ABFCACDB", str1 ="";
        Stack<Character> stack = new Stack<>();
        for(char ch: str.toCharArray()){
            if(!stack.isEmpty() && ((stack.peek() == 'A' && ch =='B') || (stack.peek() == 'C' && ch == 'D'))){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        System.out.println(stack.size());
    }
}
