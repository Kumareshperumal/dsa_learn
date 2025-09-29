package heaps;

public class HeapMain {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(5);
        heap.insert(1);
        heap.insert(3);
        heap.insert(4);
        heap.insert(6);
        heap.insert(10);
        heap.insert(2);
        heap.remove();
        heap.remove();
        heap.remove();
        heap.insert(4);
        heap.remove();

        MaxHeap maxHeap = new MaxHeap();
        int[] arr = {5,1,3,4,6,10,2,7};
        maxHeap.buildMinHeap(arr);
    }
}
