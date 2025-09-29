package leetcode.medium;

public class MaximumAscendingSubArray {
    public static void main(String[] args) {
        int[] nums =  {5,5,6,6,6,9,1,2};
        maxAscSubArr(nums);
    }

    private static void maxAscSubArr(int[] nums) {
        int sum = 0;
        int totalSum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] < nums[i]) {
                totalSum += nums[i];
            }else if(nums[i-1] > nums[i] || nums[i-1] == nums[i]) {
                if(sum < totalSum)
                    sum = totalSum;
                totalSum = nums[i];
            }
            if(i== nums.length-1){
                sum = sum < totalSum ? totalSum : sum;
            }
        }
        System.out.println("total sum ? " + sum);
    }
}
