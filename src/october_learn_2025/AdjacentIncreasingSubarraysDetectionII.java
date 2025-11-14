package october_learn_2025;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII {
    public static void main(String[] args) {
        List<Integer> l = List.of(-6,-2,-8,7,-12);
        adjacentIncrSubArrDet(l);
    }

    private static void adjacentIncrSubArrDet(List<Integer> l) {
        int curr = 0, prev = 0, max = Integer.MIN_VALUE;

        if(!l.isEmpty()) curr= curr+1;

        for(int i=1;i<l.size();i++){
            if(l.get(i) > l.get(i-1)) curr++;
            else{
               max = Math.max(max, Math.max(curr/2, Math.min(prev,curr)));
               prev = curr;
               curr=1;
            }
        }

        max = Math.max(max, Math.max(curr/2, Math.min(prev,curr)));
        System.out.println("Min list ? " + max);
    }
}
