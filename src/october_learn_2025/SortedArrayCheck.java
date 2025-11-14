package october_learn_2025;

import java.sql.Timestamp;

public class SortedArrayCheck {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,3,8};
        System.out.println(System.currentTimeMillis());
       boolean res= sortedArrch(arr);
        System.out.println(System.currentTimeMillis());
        System.out.println("Is it sorted? "+ res);
    }

    private static boolean sortedArrch(int[] arr) {
        return sortedArrchHelper(arr,1);
    }

    private static boolean sortedArrchHelper(int[] arr, int i) {

        if(i >= arr.length) return true;
        return arr[i] > arr[i-1] && sortedArrchHelper(arr, i+1);
    }
}
