package dynamic.programming.recursion.freecodecamp;

import java.util.Arrays;

public class GridTraveller {
    public static void main(String[] args) {
        grid(2, 7);
        grid(2, 3);
        grid(3, 3);
        grid(18, 18);

    }

    private static void grid(int n, int m) {
        long[][] grid = new long[n + 1][m + 1];
        System.out.println("Grid (" + n + ") ? " + Arrays.deepToString(grid));
        grid[1][1] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                long current = grid[i][j];
                if ((j + 1) <= m) grid[i][j + 1] += current;
                if ((i + 1) <= n) grid[i + 1][j] += current;
            }
        }
        System.out.println("Grid (" + n + ") ? " + Arrays.deepToString(grid));
        System.out.println(grid[n][m]);

    }
}
