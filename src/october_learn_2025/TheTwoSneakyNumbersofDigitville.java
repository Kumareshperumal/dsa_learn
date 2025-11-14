package october_learn_2025;

import java.util.*;

public class TheTwoSneakyNumbersofDigitville {
    public static void main(String[] args) {
        int[] nums = {0,3,2,1,3,2};
        findDup(nums);
    }

    private static void findDup(int[] nums) {
        Set<Integer> du = new HashSet<>();
        List<Integer> d = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(!du.add(nums[i])){
                d.add(nums[i]);
            }
        }
        int[] dup = new int[d.size()];
        for (int i=0;i<d.size();i++){
            dup[i] = d.get(i);
        }
        System.out.println(Arrays.toString(dup));
    }
}
