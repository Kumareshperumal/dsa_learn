package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,8,7,1,3,5,6,4};
        System.out.println("Before quick sort : ");
        System.out.println(Arrays.toString(arr));
        quicksort(arr, 0, arr.length-1);
        System.out.println("After quick sort : ");
        System.out.println(Arrays.toString(arr));

    }

    private static void quicksort(int[] arr, int low, int high) {
        if(low < high){
            int pivot = partition(arr, low, high);
            quicksort(arr,low,pivot-1);
            quicksort(arr,pivot+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int highestLowValue = low -1;
        int pivot = arr[high];

        //swap the position of the low values than pivot.
        //2,8,7,1,3,5,6,4
        for(int i = low; i < high; i++){
            if(arr[i] <= pivot){
                highestLowValue++;
                int temp = arr[i];
                arr[i] = arr[highestLowValue];
                arr[highestLowValue] = temp;
            }
        }

        //swap the position of the pivot, such a way that left of pivot < pivot & right of pivot > pivot.
        //swap with the highestLowValue+1, so it will satisfy the above condition.
        int temp = arr[highestLowValue+1];
        arr[highestLowValue+1] = arr[high];
        arr[high] = temp;
        //return the pivot
        return highestLowValue+1;
    }
}
