package heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> arr;

    public Heap(){
        arr = new ArrayList<>();
    }

    //5,1,6,3,4
    /*public void insert(int value){
        arr.add(value);
        int i = arr.size()-1;
        int parent = (i-1)/2;
        while(i > 0 && arr.get(i) <= arr.get(parent)){
            int temp = arr.get(i);
            arr.set(i, arr.get(parent));
            arr.set(parent, temp);
            i = parent;
            parent = (i-1)/2;
        }
        System.out.println(arr);
    }*/

    //5,1,6,3
    /*public int remove(){
        int parent = arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
        int index = 0;
        int left = (2*index)+1;
        int right = (2*index) +2;
        while(index < arr.size()){
            if(left < arr.size() && right < arr.size()){
                if(arr.get(left) < arr.get(right) && arr.get(left) < arr.get(index)){
                    int temp = arr.get(left);
                    arr.set(left,arr.get(index));
                    arr.set(index, temp);
                    index = left;
                    left = (2*index) +1;
                }else if(arr.get(right) < arr.get(index)){
                    int temp = arr.get(right);
                    arr.set(right,arr.get(index));
                    arr.set(index, temp);
                    index = right;
                    right = (2*index) +2;
                }
            }
            else break;
        }
        System.out.println("after removing heap" + arr);
        return parent;

    }*/

    public void insert(int value){
        arr.add(value);
        int index = arr.size()-1;
        int parent = (index-1)/2;
        while(index > 0 && arr.get(index) < arr.get(parent)){
            int temp = arr.get(parent);
            arr.set(parent,arr.get(index));
            arr.set(index,temp);
            index = parent;
            parent = (index-1)/2;
        }
        System.out.println("after inserting the element ? " + arr);
    }

    public int remove(){
        int parent = arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
        int index = 0;
        int left = 2*index +1;
        int right = 2*index+2;
        while(index < arr.size()){
            if(left < arr.size() && right < arr.size()){
                if(arr.get(left) < arr.get(right) && arr.get(left) < arr.get(index)){
                    int temp = arr.get(left);
                    arr.set(left,arr.get(index));
                    arr.set(index, temp);
                    index = left;
                    left = (2*index)+1;
                    right = (2*index)+2;
                }else if(arr.get(right) < arr.get(index)){
                    int temp = arr.get(right);
                    arr.set(right,arr.get(index));
                    arr.set(index, temp);
                    index = right;
                    right = (2*index)+2;
                    left = (2*index)+1;
                }
            } else break;
        }
//        System.out.println("after removing ? " + arr);
        System.out.println("parent ? " + parent);
        return parent;
    }

}
