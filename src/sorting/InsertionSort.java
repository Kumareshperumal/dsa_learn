package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        insertSort();
        insertSort1();
    }
    private static void insertSort1() {
        int[] data = {5,2,4,1};
        System.out.println("Before Insert sorting ? " + Arrays.toString(data));
        for(int i=1;i<data.length;i++){
            int key = data[i];
            int pivot = i-1;
            while(pivot >=0 && data[pivot] > key){
                data[pivot+1]=data[pivot];
                pivot--;
            }
            data[pivot+1] = key;
        }
        System.out.println("After Insert sorting ? ");
        System.out.println(Arrays.toString(data));
    }


    private static void insertSort() {
        int[] data = {5,2,4,6,1,3};
        System.out.println("Before insertion sorting : ");
        System.out.println(Arrays.toString(data));
        for(int i= 1; i<data.length; i++){
            int key = data[i];
            int j = i-1;
            //Check key < data[j] (previous values) then move these value by one position.
            //when j < 0 then exit and add the value of key into the data[j].
            while(j >= 0 && data[j] > key){
                data[j+1] = data[j];
                j = j-1;
            }
            data[j+1] = key;
        }
        System.out.println("After insertion sorting : ");
        System.out.println(Arrays.toString(data));
    }



}
