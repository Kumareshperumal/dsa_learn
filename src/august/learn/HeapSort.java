package august.learn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        heapSorting();
        int[] arr = {1, 2, 3,4};
        generate(arr.length, arr);
    }

    private static void heapSorting() {
        int[] arr = {4, 5, 2, 1, 10};
        System.out.println("before sorting " + Arrays.toString(arr));
        int arrLength = arr.length;
        //build max heap.
        /*for(int i = arrLength/2-1; i>=0;i--){
            heapify(arr,arrLength,i);
        }
        for (int i = arrLength-1;i>0;i--){
            //move the current one to the end.
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,i,0);

        }*/
        for (int n = arrLength / 2 - 1; n >= 0; n--)
            heapify(arr, arrLength, n);
        for (int n = arrLength - 1; n > 0; n--) {
            //put the largest to the end.
            int swap = arr[0];
            arr[0] = arr[n];
            arr[n] = swap;
            heapify(arr, n, 0);
        }
        System.out.println("after sorting " + Arrays.toString(arr));
    }

    private static void heapify(int[] arr, int arrLength, int i) {
       /* int largest = i;
        int left = 2*i +1;
        int right = 2*i+2;
        if(left < arrLength && arr[left] > arr[largest])
            largest = left;

        if(right < arrLength && arr[right] > arr[largest])
            largest = right;

        if(largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr,arrLength,largest);
        }*/
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < arrLength && arr[left] > arr[largest])
            largest = left;
        if (right < arrLength && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;
            heapify(arr, arrLength, largest);
        }
    }

    public static void generate(int n, int[] arr) {
        if (n == 1) {
            // Print one permutation
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            generate(n - 1, arr);

            // Swap depending on even or odd
            if (n % 2 == 0) {
                swap(arr, i, n - 1);
            } else {
                swap(arr, 0, n - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

