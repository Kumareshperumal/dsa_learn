package java8features.streamsconcepts;

import java.util.Arrays;

public class EightQueens {
    static int numOfQueens = 8;
    static int numOfCalls = 0;
    static char[][] disp = new char[numOfQueens][numOfQueens];

    public static void main(String[] args) {
        System.out.println("Before placing queen ?");
        initialDisplay(numOfQueens);
        queensProb(0);
        System.out.println("Number of recursion calls ? " + numOfCalls);
//        System.out.println("After placing queen ?");
//        initDisplay(numOfQueens);
    }

    private static void initDisplay(int numOfQueens) {
        for (int row = 0; row < numOfQueens; row++) {
            for (int col = 0; col < numOfQueens; col++) {
                System.out.print(disp[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean queensProb(int col) {
        numOfCalls++;
        if (col >= numOfQueens) {
            System.out.println("After placing queen ?");
            initDisplay(numOfQueens);
            return true;
        } else {
            for (int row = 0; row < numOfQueens; row++) {
                if (isSafe(row, col)) {
                    //choose
                    placeQueen(row, col);
                    //explore
                    boolean res = queensProb(col + 1);
                    if (res) return res;
                    //unchoose
                    removeQueen(row, col);
                }
            }
            return false;
        }
    }

    private static void removeQueen(int row, int col) {
        disp[row][col] = '.';
    }

    private static void placeQueen(int row, int col) {
        disp[row][col] = 'Q';
    }

    private static boolean isSafe(int row, int col) {
        if (disp[row][col] != 'Q') {
            // 1. Check if Queen exist in the row
            for (int col1 = 0; col1 < numOfQueens; col1++) {
                if (disp[row][col1] == 'Q') return false;
            }
            //2. Check if Queen exist in the col.
            for (int row1 = 0; row1 < numOfQueens; row1++) {
                if (disp[row1][col] == 'Q') {
                    return false;
                }
            }
            //3. Check if Queen exist in lower diagonal.
            int row1 = row;
            for (int col1 = col; col1 >= 0; col1--) {
                if (row1 < numOfQueens && disp[row1++][col1] == 'Q') {
                    return false;
                }
            }
            //4. Check if the Queen exist in upper diagonal.
            row1 = row;
            for (int col1 = col; col1 >= 0; col1--) {
                if (row1 >= 0 && disp[row1--][col1] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void initialDisplay(int numOfQueens) {
        for (int row = 0; row < numOfQueens; row++) {
            for (int col = 0; col < numOfQueens; col++) {
                disp[row][col] = '.';
                System.out.print(disp[row][col] + " ");
            }
            System.out.println();
        }

    }
}
