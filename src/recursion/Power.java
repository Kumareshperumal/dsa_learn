package recursion;

public class Power {
    public static void main(String[] args) {
        int result = powerFunction(5, 5);
        System.out.println("result of power of function " + result);

        result = powerFunction2(2, 9);
        System.out.println("result of power of function " + result);
    }

    //Tamasha notes
    private static int powerFunction2(int base, int exponent) {
        if (exponent == 0) return 1;
        else {
            int partial = powerFunction2(base, exponent / 2);
            partial *= partial;
            if (exponent % 2 == 1) partial *= base;
            return partial;
        }
    }

    //Marty notes.
    private static int powerFunction(int base, int exp) {
        if (exp < 0) throw new IllegalArgumentException("exponent should be greater than 0");
        if (exp == 1) return base;
        else if (exp % 2 == 0) return powerFunction(base * base, exp / 2);
        else return base * powerFunction(base, exp - 1);
    }
}
