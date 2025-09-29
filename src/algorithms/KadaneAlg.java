package algorithms;

import java.util.ArrayList;
import java.util.List;

public class KadaneAlg {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
       int maxSubArray= maxSubArr(arr);
        System.out.println("Maximum sub array ? "+ maxSubArray);
        subArrList(arr);
        maxCircularSubArr(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
    }

    private static int maxSubArr(int[] arr) {
        int currSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    private static void subArrList(int[] arr){
        int maxSumSoFar = arr[0];
        int maxSum = arr[0];
        int start =0, end = 0;

        for(int i=1;i<arr.length;i++){
            if(arr[i] > maxSumSoFar + arr[i]){
                maxSumSoFar = arr[i];
                start = i;
            }else{
                maxSumSoFar += arr[i];
            }

            if(maxSumSoFar > maxSum){
                maxSum = maxSumSoFar;
                end = i;
            }
        }
        System.out.println("Maximum sum so far ? " + maxSum);
        for(int j = start; j<=end;j++){
            System.out.print(arr[j] + " ");
        }
    }

    public static void maxCircularSubArr(int[] nums){
        int currMaxSoFar = 0;
        int max = Integer.MIN_VALUE;
        int currMinSoFar = 0, total = 0;
        int min = Integer.MAX_VALUE;

        if(nums.length > 0){
            currMaxSoFar = nums[0];
            currMinSoFar = nums[0];
            total = nums[0];
        }
        for(int i=1;i<nums.length;i++){

            currMaxSoFar = Math.max(nums[i], currMaxSoFar+nums[i]);
            max = Math.max(currMaxSoFar,max);

            currMinSoFar = Math.min(nums[i], currMinSoFar+nums[i]);
            min = Math.min(currMinSoFar,min);

            total += nums[i];
        }

        if(total == min)  {}
        else
        max= Math.max(max, (total-min));
        System.out.println("Maximum sub Array ? " + max);
        System.out.println("Min ? " + min + ", Max ? " + max+ " , total ? " + total);
    }

}
