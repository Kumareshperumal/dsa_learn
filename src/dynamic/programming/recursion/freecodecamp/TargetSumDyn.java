package dynamic.programming.recursion.freecodecamp;

import java.util.Arrays;

public class TargetSumDyn {
    public static void main(String[] args) {
        int[] arr = {2, 3};
        int targetSum = 7;
        targetSumDYP(targetSum, arr);
        targetSumDYP1(targetSum, arr);

        arr = new int[]{5, 3, 4, 7};
        targetSum = 7;
        targetSumDYP(targetSum, arr);
        targetSumDYP1(targetSum, arr);

        arr = new int[]{2, 4};
        targetSum = 7;
        targetSumDYP(targetSum, arr);
        targetSumDYP1(targetSum, arr);


        arr = new int[]{3, 2, 5};
        targetSum = 8;
        targetSumDYP(targetSum, arr);
        targetSumDYP1(targetSum, arr);

        arr = new int[]{7, 14};
        targetSum = 300;
        targetSumDYP(targetSum, arr);

        targetSumDYP1(targetSum, arr);

    }

    private static boolean targetSumDYP(int targetSum, int[] arr) {
        boolean[] res = new boolean[targetSum + 1];
        res[0] = true;
        System.out.println(Arrays.toString(res));
        System.out.println("after initializing ? " + Arrays.toString(res));
        for (int i = 0; i < res.length; i++) {
            if (res[i]) {
                for (int n : arr) {
                    if ((i + n) <= res.length - 1) res[i + n] = true;
                }
            }
        }
        System.out.println("result ? " + res[res.length - 1]);
        System.out.println("after processing data ? " + Arrays.toString(res));
        return res[res.length - 1];
    }

    private static String targetSumDYP1(int targetSum, int[] arr) {
        String[] res = new String[targetSum + 1];
        res[0] = "";
        System.out.println(Arrays.toString(res));
        System.out.println("after initializing ? " + Arrays.toString(res));
        for (int i = 0; i < res.length; i++) {
            if (res[i] == null || res[i].isEmpty()) {
                for (int n : arr) {
                    if ((i + n) <= res.length - 1) res[i + n] += n + "";
                }
            }
        }
        System.out.println("result ? " + res[res.length - 1]);
        System.out.println("after processing data ? targetSum is "+ targetSum +" : " + Arrays.toString(res));
        return res[res.length - 1];

    }

}
