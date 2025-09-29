package august.learn;

import java.util.Arrays;

public class KthLargestNumber {
    public static void main(String[] args) {
        kthLarNum();
    }

    private static void kthLarNum() {
        int nums[] = {3, 2, 1, 5, 4, 11, 2, 7}, k = 2;
        //get the largest element.
        for (int n = nums.length / 2 - 1; n >= 0; n--)
            heapifyK(nums, nums.length, n);
        //sort the element in ascending order.
        for (int n = nums.length - 1; n > nums.length - (k + 1); n--) {
            //set the largest element to last.
            int swap = nums[0];
            nums[0] = nums[n];
            nums[n] = swap;
            heapifyK(nums, n, 0);
        }
        System.out.println("Kth largest number ? " + nums[nums.length - 2]);
    }

    private static void heapifyK(int[] nums, int length, int n) {
        int largest = n;
        int left = 2 * n + 1;
        int right = 2 * n + 2;
        if (left < length && nums[left] < nums[largest])
            largest = left;
        if (right < length && nums[right] < nums[largest])
            largest = right;
        if (largest != n) {
            int swap = nums[largest];
            nums[largest] = nums[n];
            nums[n] = swap;
            heapifyK(nums, length, largest);
        }
    }
}
