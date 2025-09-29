package september_learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        int[] candidates = new int[]{1,2,3};
        int target = 2;
        combinations(candidates, target);
    }

    private static void combinations(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> combinations = new ArrayList<>();
       combinationsHelper(candidates, target, combination,0, combinations);
        System.out.println(combinations);
    }

    private static void combinationsHelper(int[] candidates, int target, List<Integer> combination, int start, List<List<Integer>> combinations) {
        if(target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
            for(int i = start; i < candidates.length;i++){
                if(target >= candidates[i]) {
                    combination.add(candidates[i]);
                    combinationsHelper(candidates, target - candidates[i], combination, i, combinations);
                    combination.remove(combination.size() - 1);
                }
            }
    }

}
