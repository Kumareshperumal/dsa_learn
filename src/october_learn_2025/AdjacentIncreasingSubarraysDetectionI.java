package october_learn_2025;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {
    public static void main(String[] args) {
        List<Integer> l = List.of(/*1,2,3,4,4,4,4,5,6,7*/2,5,7,8,9,2,3,4,3,1);
        int k = 3;
       boolean r = adjIncrSubArrDetI(l,k);
        System.out.println("Adjacent subarray exist ? " + r);
    }

    private static boolean adjIncrSubArrDetI(List<Integer> l, int k) {
        if(l.isEmpty()) return false;
        int curr=1,prev=0, m=0;
        for(int i=1;i<l.size();i++){
            if(l.get(i) > l.get(i-1)) curr++;
            else{
                 m = Math.max(m,Math.max(curr/2,Math.min(prev,curr)));
                 prev=curr;
                 curr =1;
                 if(m >= k)
                     break;
            }
        }
        return k <= Math.max(m,Math.max(curr/2,Math.min(prev,curr)));
    }
}
