package recursion;

public class Mystery {
    public static void main(String[] args) {
        int result = mysteryMethod(648);
        System.out.println("result of Mystery number ? " + result);
    }

    private static int mysteryMethod(int number) {

        if(number < 10){
            return number;
        }else{
            int a = number / 10;
            int b = number % 10;
            return mysteryMethod(a+b);
        }
    }
}
