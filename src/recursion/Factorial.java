package recursion;

public class Factorial {

    public static void main(String[] args) {
        factorialLoop(5);
        int result = recursiveFactorial(5);
        System.out.println("recursive factorial ? " + result);
        int accum = 1;
        result = tailFactorial(6, accum);
        System.out.println("tail recursive factorial ? " + result);

        //Factorial
       result = factorialNew(5);
       System.out.println("Factorial result ? " + result);
    }


    private static int tailFactorial(int num, int accum) {
        if (num <= 1) {
            return accum;
        } else {

            return tailFactorial(num - 1, accum * num);
        }
    }

    private static int recursiveFactorial(int i) {
        if (i < 2) return 1;
        else return recursiveFactorial(i - 1) * i;
    }

    private static void factorialLoop(int n) {
        /*
        stacks up a method, like spawn a new method for each call.
         */
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        System.out.println("factorial using loop ? " + result);
    }

    //Again started learning recursion :: Mar 1/ 2025 && may 10/2025
    private static int factorialNew(int n) {
       if(n==0 || n==1)
           return 1;
       else return n * factorialNew(n-1);
    }
}
