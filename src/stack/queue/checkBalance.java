package stack.queue;

import java.util.Stack;

public class checkBalance {
    public static void main(String args[]){
        String s = "{([]})";
        boolean res = isMatched(s);
        System.out.println("is \" " + s + " \" a valid parentheses ? " + res);
        s = "( )(( )){([( )])}";
        res = isMatched(s);
        System.out.println("is \" " + s + " \" a valid parentheses ? " + res);
        s = ")(()){([()])}";
        res = isMatched(s);
        System.out.println("is \" " + s + " \" a valid parentheses ? " + res);
        s = "if (x) {";
        res = isMatched(s);
        System.out.println("is \" " + s + " \" a valid parentheses ? " + res);
        s = "if (a(4) > 9) { foo(a(2)); }";
        res = isMatched(s);
        System.out.println("is \" " + s + " \" a valid parentheses ? " + res);

    }
    private static boolean isMatched(String s) {
        Stack<Character> stack = new Stack<>();
        final String opening = "[{(";
        final String closing = "]})";
        for(char c: s.toCharArray()){
            if(opening.indexOf(c) != -1)
                stack.push(c);
            else if(closing.indexOf(c) != -1){
                if(stack.isEmpty() || opening.indexOf(stack.pop()) != closing.indexOf(c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
