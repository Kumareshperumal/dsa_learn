package september_learn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        permute(nums);
    }

    private static void permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        System.out.println("List? " +list);
        List<Integer> chosen = new ArrayList<>();
        List<List<Integer>> finalData = new ArrayList<>();
        System.out.println( permuteHelper(list,chosen, finalData));

    }

    //[[2,2,1,1],[2,1,1,2],[2,1,2,1],[1,1,2,2]]
    private static List permuteHelper(List<Integer> list, List<Integer> chosen, List finalData) {

        for(int i = 0; i<list.size();i++){
            int removeFirst = list.remove(i);
            chosen.add(removeFirst);
            if(list.isEmpty()) {
                System.out.println(chosen);
                finalData.add(new ArrayList<>(chosen));
            }
            else
            {
                    permuteHelper(list, chosen, finalData);
            }
            chosen.remove(chosen.size()-1);
            list.add(i, removeFirst);
        }
        return finalData;
    }
}
