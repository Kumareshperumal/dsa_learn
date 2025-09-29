package linkedlist;

import august.learn.SinglyLinkedListRoberto;

public class MainSinglyLL {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        linkedList.addFirst(42);
        linkedList.addFirst(23);
        linkedList.addLast(-7);
        linkedList.addFirst(99);
        System.out.println("first Element ? " + linkedList.first());
        linkedList.print();
        linkedList.print();


        SinglyLinkedListRoberto<Integer> listRoberto = new SinglyLinkedListRoberto<>();
        listRoberto.addFirst(33);
        listRoberto.addLast(34);
        listRoberto.addFirst(67);
        System.out.println("Printing singly linked list ? ");
        listRoberto.print();
        listRoberto.addLast(88);
        listRoberto.addFirst(78);
        listRoberto.addFirst(45);
        listRoberto.removeFirst();
        System.out.println("Printing singly linked list ? ");
        listRoberto.print();
    }
}
