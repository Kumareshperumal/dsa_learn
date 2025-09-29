package september_learn;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountElementwithMaxFreq {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};
        maxFreq(nums);
    }

    private static void maxFreq(int[] nums) {
       Map<Integer, Integer> freqMap =  Arrays.stream(nums)
               .boxed()
               .collect(Collectors.toMap(Function.identity(), v -> 1, (o, n)-> o+n));
        System.out.println(freqMap);
        int max = 0;
        for(int d : freqMap.values()){
            int curr = d;
            max = Math.max(curr, max);
        }
        System.out.println("max repeat count ? " + max);

        int totalFreq = 0;

        for(int d:freqMap.values()){
            if(max == d){
                totalFreq += max;
            }
        }
        System.out.println("total freq count : " + totalFreq);

        //Array method

        int[] freq = new int[50];
         max = 0;
        for(int n: nums){
             freq[n]++;
            max = Math.max(freq[n], max);
        }
        System.out.println(Arrays.toString(freq) + " max : " + max);
        int count = 0;
        for(int m: freq){
            if(m == max) count += m;
        }
        System.out.println("total freq ? " + count);
    }

}
