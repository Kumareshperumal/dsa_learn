package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubListsRecursion {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("Jane", "Bob", "Matt", "Sara"));
        sublists(input);
        int[] inputs = new int[]{1,2,3};
        sublist(inputs);
    }

    private static void sublist(int[] inputs) {
        List output = new ArrayList();
        List chosen = new ArrayList();
        sublist(inputs,output,chosen);
    }

    private static void sublist(int[] inputs, List output, List chosen) {
        if(inputs.length == 0) output.add(new ArrayList<>(chosen));
        else{
            int choose = inputs[0];
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
