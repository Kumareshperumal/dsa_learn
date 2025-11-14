package November_learn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    public static void main(String[] args) {
        int n = 3, open = 0;
        List<String> str = new ArrayList<>();
        gp(n, open, str,"(");
        System.out.println(str);
        str = new ArrayList<>();
        gp1(n,str, "", 0, 0);
        System.out.println("using optimal way : " + str);
    }

    //Optimal solution.
    private static void gp1(int n, List<String> str, String s, int o, int c) {
        System.out.println("n == " + n + ", open == " + o + ", list == " + str+ " , paranthesis == " + s + ", p - length == " + s.length());
        if(s.length() == (n*2)){
            str.add(s);
        }else{
            if(o < n){
                gp1(n, str, s+"(",o+1,c);
            }if(c < o){
                gp1(n,str,s+")",o,c+1);
            }
        }
    }

    private static void gp(int n, int open, List<String> str, String p) {
//        System.out.println("n == " + n + ", open == " + open + ", list == " + str+ " , paranthesis == " + p + ", p - length == " + p.length());
        if(p.length() == (n * 2)){
            str.add(p);
        }
        else{
            if(countOpenBracket(p, n) && p.charAt(p.length()-1)=='('){

                gp(n,open+1,str,p+")");
                gp(n,open,str,p+"(");

            }
            else if(p.charAt(p.length()-1)==')' && countOpenBracket(p, n)){
                gp(n,open,str,p+"(");
                gp(n,open+1,str,p+")");
            }
            else if(countOpenBracket1(p,n)){
                gp(n,open+1,str,p+"(");
            }
            else{
                gp(n,open+1,str,p+")");
            }
        }
    }

    private static  boolean countOpenBracket(String p, int n){
        int countOpen = 0, countClose = 0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i) == '('){
                countOpen+=1;
            }if(p.charAt(i) == ')'){
                countClose +=1;
            }
        }
        return countOpen < n && countClose < n && countOpen > countClose;
    }

    private static  boolean countOpenBracket1(String p, int n){
        int countOpen = 0, countClose = 0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i) == '('){
                countOpen+=1;
            }if(p.charAt(i) == ')'){
                countClose +=1;
            }
        }
        return countClose < n && countOpen == countClose;
    }
}
