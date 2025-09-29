package august.learn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxHeapByPriorityQueue {
    public static void main(String[] args) {
        heap();
    }

    private static void heap() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] arr = {8, 4, 5, 3, 9, 1};
        System.out.println(Arrays.toString(arr));
        Arrays.stream(arr).forEach(i -> minHeap.add(i));
        for (int i = 0; i < arr.length; i++) {
            Integer smallest = minHeap.poll();
            arr[i] = smallest;
        }

        System.out.println(Arrays.toString(arr));

    }
}
