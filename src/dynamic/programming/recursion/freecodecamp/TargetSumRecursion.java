package dynamic.programming.recursion.freecodecamp;

import java.util.HashMap;
import java.util.Map;

public class TargetSumRecursion {
    static String res = "";

    public static void main(String[] args) {
        int[] numbers = {2, 3};
        Map<Integer, Boolean> memo = new HashMap<>();
        boolean result = sumTarget(7, numbers, memo, res);
        System.out.println("result of targetSum ? " + result);
        numbers = new int[]{2, 3};
        Map<Integer, String> memo1 = new HashMap<>();
        Long startTime = System.currentTimeMillis();
        String res1 = sumTarget1(8, numbers, memo1, res);
        Long endTime = System.currentTimeMillis();
        System.out.println("total time taken ? " + (endTime - startTime));
        System.out.println("result of combination targetSum ? " + (res1 != null ? "{" + (res1.substring(0, res1.length() - 1)) + "}" : null));

    }

    private static boolean sumTarget(int targetSum, int[] numbers, Map<Integer, Boolean> memo, String res) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        } else if (targetSum == 0) {
            System.out.println("comb ? " + res.substring(0, res.length() - 1));
            return true;
        } else if (targetSum < 0) return false;
        else {
            for (int n : numbers) {
                int constructTargetSum = targetSum - n;
                if (constructTargetSum >= 0 && sumTarget(constructTargetSum, numbers, memo, "" + n + "," + res)) {
                    memo.put(targetSum, true);
                    return true;
                }
            }
            memo.put(targetSum, false);
            return false;
        }

    }

    private static String sumTarget1(int targetSum, int[] numbers, Map<Integer, String> memo, String res) {
        if (memo.containsKey(targetSum)) {
            return memo.get(res);
        } else if (targetSum == 0) {
            System.out.println("comb ? " + res.substring(0, res.length() - 1));
            return res;
        } else if (targetSum < 0) return null;
        else {
            for (int n : numbers) {
                int constructTargetSum = targetSum - n;
                if (constructTargetSum >= 0) {
                    String res1 = sumTarget1(constructTargetSum, numbers, memo, "" + n + "," + res);
                    if (res1 != null) {
                        memo.put(targetSum, res1);
                        return res1;
                    }
                }
            }
            memo.put(targetSum, null);
            return null;
        }

    }


}
