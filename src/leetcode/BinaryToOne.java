package leetcode;

import java.math.BigInteger;

public class BinaryToOne {
    /*
    Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:

     If the current number is even, you have to divide it by 2.

     If the current number is odd, you have to add 1 to it.
     */
    public static void main(String[] args) {
        String binaryString = "1101";
        int stepsCount = 0;
        BigInteger decimalNumber = binary(binaryString);
//        long decimalNum = decimalNumber.intValue();
        int res = stepsToOne(decimalNumber, stepsCount);
        System.out.println("steps to count ? " + res);
        int steps = numSteps(binaryString);
        System.out.println("steps ? " + steps);
    }

    public static  int numSteps(String s) {
        int res = 0, carry = 0;

        for(int i = s.length() - 1; i> 0; i--){
            res++;
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                res ++;
            }

        }

        return res + carry;
    }

    private static int stepsToOne(BigInteger decimalNumber, int stepsCount) {
        while (decimalNumber.compareTo(BigInteger.ONE) > 0) {
            stepsCount++;
            BigInteger dec = decimalNumber.remainder(new BigInteger("2"));
            if (dec.compareTo(BigInteger.ONE) == 0) {
                decimalNumber = decimalNumber.add(BigInteger.ONE);
            } else {
                decimalNumber = decimalNumber.divide(BigInteger.TWO);
            }
        }
        return stepsCount;
    }

    private static BigInteger binary(String binaryString) {
        BigInteger decimalNumber = new BigInteger(binaryString, 2);
        return decimalNumber;
    }
}
