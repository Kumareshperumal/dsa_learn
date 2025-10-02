package september_learn;

import java.util.Arrays;

public class FindTriangularSumOfArray {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        int res = triangleSum(num);
        System.out.println(res);
    }

    private static int triangleSum(int[] num) {
        int[] newNums = new int[num.length-1];
        int pivot = 0;
        System.out.println(Arrays.toString(num));
        if(num.length <=1) return num[0];
        for(int i =1; i< num.length;i++){
            newNums[pivot] = (num[pivot] + num[i]) % 10;
            pivot++;
        }
        return triangleSum(newNums);
    }
}
