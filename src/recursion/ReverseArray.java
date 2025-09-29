package recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int data[] = {4, 3, 6, 2, 7, 8, 9, 5};
        System.out.println("Before reversing arr ? " + Arrays.toString(data));
        reversingArr(data, 0, data.length - 1);
        System.out.println("after reversing arr? " + Arrays.toString(data));
    }

    private static void reversingArr(int[] data, int low, int high) {
        if (low < high) {
            int temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
            reversingArr(data, low, high);
        }
    }
}
