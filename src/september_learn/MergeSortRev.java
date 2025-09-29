package september_learn;

import java.util.Arrays;

public class MergeSortRev {
    public static void main(String[] args) {
        int[] arr ={24,-12,8,9,4};
        System.out.println("Before Sorting ? " + Arrays.toString(arr));
        mergeSorting(arr);
    }

    private static void mergeSorting(int[] arr) {
        int start = 0, end = arr.length;
        mergeSortingHelper(arr, start, end);

        System.out.println("After Sorting ? " + Arrays.toString(arr));
    }

    private static void mergeSortingHelper(int[] arr, int start, int end) {
        if(start < end -1) {
            int mid = (start + end) / 2;
            mergeSortingHelper(arr, start, mid);
            mergeSortingHelper(arr, mid, end);
            merges(arr, start, mid, end);
        }

    }

    private static void merges(int[] arr, int start, int mid,int end) {
        int l = 0, r =0, k=start;
        int[] left = Arrays.copyOfRange(arr,start,mid);
        int[] right = Arrays.copyOfRange(arr,mid,end);
        for(int i=0; i<(left.length + right.length); i++){
            if(r >= right.length || (l < left.length && left[l] < right[r])){
                arr[k++] = left[l++];
            }else arr[k++] = right[r++];
        }
    }
}
