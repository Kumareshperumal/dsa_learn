package dynamic.programming.recursion.freecodecamp;


import java.util.HashMap;
import java.util.Map;

public class GridTravellerRecursion {
    static Map<String, Long> result = new HashMap<>();

    public static void main(String[] args) {
        long sum = gridDim(18, 18);
        System.out.println("sum ? " + sum);
    }

    private static long gridDim(int row, int col) {
        if ((row == 1) && (col == 1)) return 1;
        else if ((row == 0) || (col == 0)) return 0;
        if (result.containsKey((row + "," + col))) {
            return result.get((row + "," + col));
        } else {
            long data = gridDim(row - 1, col) + gridDim(row, col - 1);
            result.put((row + "," + col), data);
            return data;
        }
    }
}
