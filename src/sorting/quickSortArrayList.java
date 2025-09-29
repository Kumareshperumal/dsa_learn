package sorting;

import java.util.Arrays;
import java.util.List;

public class quickSortArrayList {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2,8,7,1,3,5,6,4);
        System.out.println("Before quick sort : ");
        System.out.println(input);
        quicksorting(input, 0, input.size()-1);
        System.out.println("After quick sort : ");
        System.out.println(input);

    }

    private static void quicksorting(List<Integer> input, int low, int high) {
        if(low <high){
            int pivot = partitionList(input, low, high);
            quicksorting(input,low,pivot-1);
            quicksorting(input,pivot+1,high);
        }
    }

    private static int partitionList(List<Integer> input, int low, int high) {
        int pivot = input.get(high);
        int highestLowElement = low -1;

        for(int i = low; i< high; i++){
            if(input.get(i) <= pivot){
                highestLowElement++;
                int temp = input.get(i);
                input.set(i,input.get(highestLowElement));
                input.set(highestLowElement, temp);
            }
        }

        int temp = input.get(highestLowElement+1);
        input.set(highestLowElement+1, input.get(high));
        input.set(high, temp);

        return highestLowElement+1;
    }
}
