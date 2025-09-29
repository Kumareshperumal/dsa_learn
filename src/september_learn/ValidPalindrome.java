package september_learn;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        isPalindromee(str);
    }

    private static void isPalindromee(String str) {
        String newStr = "";
        for(int i=0; i<str.length();i++){
            if(Character.isLetterOrDigit(str.charAt(i))){
                newStr += str.charAt(i)+"".toLowerCase();
            }
        }
        System.out.println(newStr);
        newStr = newStr.toLowerCase();
        int start =0, end = newStr.length()-1;
        boolean flag = true;
        while (start <= end){
            if(newStr.charAt(start) == newStr.charAt(end)){
                start++;
                end--;
            }else{
                System.out.println("Not a palindrome");
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("palindrome" + start + ", " + end);

    }
}
