package sorting;

import java.util.Arrays;

public class MergeSort1 {
    public static void main(String[] args) {
        int[] numbersArray = {24,-12,8,9,4};
        mergeSort(numbersArray);
    }

    private static void mergeSort(int[] numbersArray) {

        int start = 0, end = numbersArray.length;
        mergeSort(start, end, numbersArray);
        System.out.println(Arrays.toString(numbersArray));
    }

    private static void mergeSort(int start, int end, int[] numbersArray) {
        if (start >= end - 1) return; // because end is exclusive.
        int mid = (start + end) / 2;
        mergeSort(start, mid, numbersArray);
        mergeSort(mid, end, numbersArray);
        merge(start, mid, end, numbersArray);
    }

    private static void merge(int start, int mid, int end, int[] numbersArray) {

        int[] left = Arrays.copyOfRange(numbersArray, start, mid);
        int[] right = Arrays.copyOfRange(numbersArray, mid, end);

        int l = 0, r = 0, k = start;

        //merge the left and right arrays.
//        while (l < left.length && r < right.length) {
//            if (left[l] < right[r]) {
//                numbersArray[k++] = left[l++];
//            } else {
//                numbersArray[k++] = right[r++];
//            }
//        }
//
//        //merge the remaing left arrays.
//        while (l < left.length) {
//            numbersArray[k++] = left[l++];
//        }
//        //merge the remaining right arrays.
//        while (r < right.length) {
//            numbersArray[k++] = right[r++];
//        }

        //Marty's logic
        for(int i=0; i<(left.length + right.length); i++) {
            if (r >= right.length || (l < left.length && (left[l] < right[r]))) {
                numbersArray[k++] = left[l++];
            }else numbersArray[k++] = right[r++];
        }

    }
}
