package leetcode.medium;

import java.util.Arrays;

public class RemoveDuplicateSortedArr {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
       int length =  removeDup(nums);
        System.out.println(Arrays.toString(nums) + ", length ? " + length);
    }

    private static int removeDup(int[] nums) {
        int pivot = 0;
            for(int i = 1; i < nums.length; i++){
                if(nums[pivot] < nums[i]){
                    pivot++;
//                    int temp = nums[pivot];
                    nums[pivot] = nums[i];
//                    nums[i] = temp;

                }
            }
            return pivot+1;
        }
}
