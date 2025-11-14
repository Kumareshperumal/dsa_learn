package November_learn;

import java.util.Arrays;
import java.util.Stack;

public class MinimumOperationstoConvertAllElementstoZero {
    static int minOperationsRequired = 0;
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2};
        minOpToConAllEleToZro(nums, 0);
        System.out.println(Arrays.toString(nums));
        System.out.println("Minimum number of Operations to convert elements to Zero : " + minOperationsRequired);
        nums = new int[]{1, 2, 1, 2, 1, 2};
        minOpToConAllEleToZero(nums);
        minOperations(nums);
    }

    public static int minOperations(int[] nums) {
        int[] stack = new int[nums.length + 1];
        int top = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            while (stack[top] > nums[i]) {
                top--;
                ans++;
            }
            if (stack[top] != nums[i])
                stack[++top] = nums[i];
        }

        return ans + top;
    }

    private static void minOpToConAllEleToZero(int[] nums) {
        Stack<Integer> stack = new Stack<>();
       int minOperationsReq= 0;
        for(int n: nums){
            while(!stack.isEmpty() && stack.get(stack.size()-1) > n){
                stack.remove(stack.size()-1);
            }
            if(n == 0) continue;
            if(stack.isEmpty() || stack.get(stack.size()-1) < n){
                minOperationsReq+=1;
                stack.add(n);
            }
        }
        System.out.println("Minimun Operations required to convert elements to Zero : " + minOperationsReq);
    }

    private static void minOpToConAllEleToZro(int[] nums, int pivot) {
        int min = Integer.MAX_VALUE;
        int l = Integer.MIN_VALUE, r = nums.length;
        for(int i=0; i<nums.length;i++){
            if(nums[i] > 0 && nums[i] < min){
                l = i;
                min = Math.min(min,nums[i]);
            }
            if(l >= 0 && nums[i] == 0) {
                r = i;
                break;
            }
        }
        System.out.println("min and max " + l+ " : " + r);
        if(l >= 0){
            for(int i=l;i<r;i++){
                if(nums[i] == min){
                    nums[i] = 0;
                }
            }
            if(pivot < nums.length) {
                minOperationsRequired += 1;
                minOpToConAllEleToZro(nums, pivot + 1);
            }
        }


    }
}
