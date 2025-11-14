package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubListsRecursion {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("Jane", "Bob", "Matt", "Sara"));
//        sublists(input);
        List<Integer> inputs = new ArrayList<>(List.of(1,2,3));
        sublist(inputs);
    }

    private static void sublist(List<Integer> inputs) {
        List output = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
//        sublist(inputs,output,chosen);
        System.out.println("Output : "+output);
        int[] nums = new int[]{1,2,2};
        Arrays.sort(nums);
        sublist1(nums, new ArrayList<>(), 0);
    }

    private static void sublist1(int[] nums, ArrayList<Object> list, int p) {
        System.out.println(" list : " + list +", pivot : " + p);
        for(int i=p;i<nums.length;i++){
            if(i>p && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
//            System.out.println(" list : " + list +", pivot : " + i);
            sublist1(nums,list, i+1);
            list.remove(list.size()-1);
        }

    }

    private static void sublist(List<Integer> inputs, List output, List<Integer> chosen) {
        System.out.println("Inputs : " + inputs + ", chosen : " + chosen);
        if(inputs.isEmpty()) {
            System.out.println(chosen);
            output.add(new ArrayList<>(chosen));
        }
        else{
           Integer c=  inputs.remove(0);
            chosen.add(c);
            sublist(inputs, output,chosen);
            int exclude = chosen.remove(chosen.size()-1);
            sublist(inputs,output,chosen);
            inputs.add(exclude);
        }
    }

    private static void sublists(List<String> input, List<String> chosen) {
        System.out.println(Permute.recursionIndent(input.size()) +" , input.size() " + input.size() + ", input " + input + ", chosen : " + chosen);
        if (input.isEmpty()) System.out.println(chosen);
        else {
            //Choose
            String addChosen = input.remove(0);
            //Explore/Search.
            //Yes. Include them.
            chosen.add(addChosen);
            sublists(input, chosen);
            //No,  exclude them.
            String unchoose = chosen.remove(chosen.size() - 1);
            sublists(input, chosen);
            input.add(unchoose);
        }
    }

    private static void sublists(List<String> input) {
        List<String> chosen = new ArrayList<>();
        sublists(input, chosen);
    }


}
