package september_learn;

import java.util.HashMap;
import java.util.Map;

public class Fibonaccis {
    public static void main(String[] args) {
        fib(5);
    }

    private static void fib(int i) {
        Map<Integer, Integer> memory = new HashMap<>();
        int output = fibHelper1(6);
        System.out.println(output);
       int res = fibHelper(i, memory);
        System.out.println(res);

    }

    private static int fibHelper(int i, Map<Integer, Integer> memory) {
        if(i == 1 || i ==0) return i;
       if(memory.containsKey(i)){
           return memory.get(i);
       }
       int temp = fibHelper(i-1,memory) + fibHelper(i-2,memory);
       memory.put(i, temp);
       return temp;
    }

    private static int fibHelper1(int i){
        int prev =0, curr = 1;
        for(int val = 2; val <= i; val++){
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
