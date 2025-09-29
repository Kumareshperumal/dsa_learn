package september_learn;

import java.util.Arrays;

public class InsertionSorting {
    public static void main(String[] args) {
        int[] arr = {24,12,-9,3,17};
        insertions(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertions(int[] arr) {
        int pivot = 0;
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            pivot = i-1;
            while(pivot >= 0 && arr[pivot] > key){
                arr[pivot+1] = arr[pivot];
                pivot--;
            }
            arr[pivot+1] = key;
        }
    }
}
