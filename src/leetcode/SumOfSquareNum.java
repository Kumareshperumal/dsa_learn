package leetcode;

public class SumOfSquareNum {
    public static void main(String[] args) {
        boolean result = sumOfSquare(5);
        System.out.println("result ? " + result);
    }

    private static boolean sumOfSquare(int num) {
        long sqRoot = (long) Math.sqrt(num);
        int low = 0;
        while (low <= sqRoot) {
            if ((low * low) + (sqRoot * sqRoot) == num) return true;
            else if ((low * low) + (sqRoot * sqRoot) < num) low++;
            else sqRoot--;
        }
        return false;
    }
}
