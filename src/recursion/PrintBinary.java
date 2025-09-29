package recursion;

import java.util.Arrays;
import java.util.List;

public class PrintBinary {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 13, 27, 42, 50, 99);
        for (int num : nums) {
            String result = printingBinary(num, "");
            System.out.println("Binary of " + num + " ? " + result);
        }
    }

    private static String printingBinary(int num, String result) {
        if (num <= 1) {
            result = String.valueOf(num);
            return result;
        } else {
            result = printingBinary(num / 2, result + result);
            return result + printingBinary(num % 2, result);
        }
    }
}
