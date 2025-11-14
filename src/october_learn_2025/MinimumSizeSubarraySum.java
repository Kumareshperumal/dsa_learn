package october_learn_2025;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,2,3,4,5};
        minSubArrSum(target,nums);
    }

    private static void minSubArrSum(int target, int[] nums) {
        int pivot = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                min = Math.min(min,(i-pivot)+1);
                sum -= nums[pivot++];
            }
        }
        if(min == Integer.MAX_VALUE) min = 0;
        System.out.println("min size sub array sum ? " + min);
    }
}
