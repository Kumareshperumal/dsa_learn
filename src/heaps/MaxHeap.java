package heaps;

import java.util.Arrays;

public class MaxHeap {

    public void maxiHeap(int[] arr){
        System.out.println("Before Max Heap ? " + Arrays.toString(arr));
        int length = arr.length/2;
        for(int i = length; i >0 ; i--){
            heapAlg(arr, i-1);
        }
        System.out.println(Arrays.toString(arr));
    }

    //3,5,2,6,7
    private void heapAlg(int[] arr, int index) {
        int left = 2*index +1;
        int right = 2*index +2;
        while(left < arr.length){
               if(right < arr.length && arr[left] > arr[right]){
                   int temp = arr[right];
                   arr[right] = arr[index];
                   arr[index] = temp;
                   index = right;
                   right = 2*index+1;
                   left = 2*index +1;
               }else if(arr[left] < arr[index]){
                   int temp = arr[left];
                   arr[left] = arr[index];
                   arr[index] = temp;
                   index = left;
                   left = 2*index+1;
                   right = 2*index +2;
               }else {
                   break;
               }
        }
    }

    public void buildMinHeap(int[] arr){
        System.out.println("Before Min Heap: " + Arrays.toString(arr));
        int length = arr.length / 2;  // Start from the last non-leaf node
        for(int i = length - 1; i >= 0; i--){
            heapify(arr, arr.length, i);
        }
        System.out.println("After building Min Heap: " + Arrays.toString(arr));
    }

    private void heapify(int[] arr, int n, int i) {
        int smallest = i; // Initialize the smallest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child is smaller than the root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // If right child is smaller than the smallest so far
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If the smallest is not the root, swap and continue heapifying
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, smallest);
        }
    }
}
