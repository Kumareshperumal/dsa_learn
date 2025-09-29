package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        twoSums();
    }

    private static void twoSums() {
//        int[] nums = {2,7,11,15};
        int[] nums = {3,3};
        int target = 6;
        int[] result = new int[2];
        Map<Integer, Integer> targetMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(targetMap.containsKey(target-nums[i])){
                result[0] = targetMap.get(target-nums[i]);
                result[1] = i;
                break;
            }
            targetMap.put(nums[i],i);
        }
        System.out.println(Arrays.toString(result));
    }
}
