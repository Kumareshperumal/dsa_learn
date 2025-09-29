package stack.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stutter {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        stutterQueue(q);
        Queue<Character> q1 = new LinkedList<>();
        q1.add('a');
        q1.add('b');
        q1.add('c');
        mirrorQueue(q1);
    }

    private static void mirrorQueue(Queue<Character> q1) {
        int size = q1.size();
        Stack<Character> s= new Stack<>();
        for(int i=0;i<size;i++){
            char c = q1.poll();
            s.push(c);
            q1.add(c);
        }
        while(!s.isEmpty()){
            q1.add(s.pop());
        }
        System.out.println(q1);
    }

    private static void stutterQueue(Queue<Integer> q) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int temp = q.remove();
            q.add(temp);
            q.add(temp);
        }
        System.out.println(q);
    }
}
