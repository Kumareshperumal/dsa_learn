package september_learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
        int[] input = {1,1,2,2};
        permutationsUnique(input);
    }

    private static void permutationsUnique(int[] input) {
        List<Integer> in = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        for (int i=0;i<input.length;i++) in.add(input[i]);
        Collections.sort(in);
        List output = new ArrayList();
        permutationsUniqueHelper(in, chosen, output);
        System.out.println("Permutations without duplicates : " + output);
    }

    private static void permutationsUniqueHelper(List<Integer> in, List<Integer> chosen,List<List<Integer>> output) {
       for(int i=0;i<in.size();i++){
           if(i >0 && in.get(i) == in.get(i-1)) continue;
           int select = in.remove(i);
           chosen.add(select);
           if(in.isEmpty()) output.add(new ArrayList<>(chosen));
           else{
               permutationsUniqueHelper(in,chosen,output);
           }
           chosen.remove(chosen.size()-1);
           in.add(i,select);
       }
    }
}
