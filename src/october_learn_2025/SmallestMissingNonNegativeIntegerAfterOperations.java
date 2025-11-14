package october_learn_2025;

import java.util.*;

public class SmallestMissingNonNegativeIntegerAfterOperations {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-10,7,13,6,8};
        int v = 5;
        int r = missNonNegNum(nums,v);
        System.out.println("Minimum non-negative value : "+r);
    }

    private static int missNonNegNum(int[] nums, int value) {
       Map<Integer, Integer> map = new HashMap<>();

       for(int i=0; i<nums.length;i++){
           int index= ((nums[i] % value) + value) % value;
           map.put(index, map.getOrDefault(index,0) +1);
       }
       int mex=0;
       while(true){
           int mod = mex % value;
           int r = map.getOrDefault(mod, 0);
           if(r == 0) return mex;
           map.put(mod, r-1);
           mex++;
       }
    }
}
