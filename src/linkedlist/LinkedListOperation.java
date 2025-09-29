package linkedlist;

import java.util.List;

public class LinkedListOperation {
    ListNode node;

    public LinkedListOperation() {
    }

    public LinkedListOperation(ListNode node) {
        this.node = node;
    }

    public void printData(ListNode node1) {
        ListNode temp = node1;
        System.out.println("List of data ? ");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int size(ListNode node1) {
        int count = 0;
        ListNode current = node1;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int get(ListNode node1, int index) {
        ListNode curr = node1;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public ListNode add(ListNode node, int value) {
        ListNode curr = new ListNode(value);
        ListNode front = node;
        if (node == null) {
            node = curr;
            return node;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = curr;
        }
        node = front;
        return node;
    }

    public ListNode addFirst(ListNode node, int value){
        //Assuming Node is not empty
//        ListNode newNode = new ListNode(value);
//        newNode.next = node;
//        node = newNode;

        node = new ListNode(value, node);
        return node;
    }

    public ListNode removeFirst(ListNode front){
        //Assuming front is not null
        int removedElement = front.data;
        System.out.println("removedElement from front value ? " + removedElement);
        front = front.next;
        return front;
    }
    public ListNode remove(ListNode front, int index){
        //Assuming front is not null! 99 42 23 35 -7
        ListNode curr = front;
        for(int i=1;i<index-1;i++){
            front = curr.next;
        }
        int removedValue = front.next.data;
        System.out.println("removed Element ? " + removedValue);
        front.next = front.next.next;
        return front;
    }
}
