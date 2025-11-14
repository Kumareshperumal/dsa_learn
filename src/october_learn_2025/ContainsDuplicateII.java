package october_learn_2025;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        duplicateExist(nums, k);

    }

    private static void duplicateExist(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(m.containsKey(nums[i])){
                if(Math.abs(i- m.get(nums[i])) <= k){
                    System.out.println("Duplicate exist within this range ? " + k);
                    break;
                }
            }
            m.put(nums[i],i);
        }
    }
}
