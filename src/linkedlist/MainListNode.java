package linkedlist;

public class MainListNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(42);
        node1.next = new ListNode(-3);
        node1.next.next = new ListNode(17);
        node1.next.next.next = new ListNode(9);
        LinkedListOperation linkedListOperation = new LinkedListOperation();
        //Print the list of data in a linkedlist.
        linkedListOperation.printData(node1);
        //Size of the list
        int size = linkedListOperation.size(node1);
        System.out.println("Size of the list ? " + size);
        //get the index value;
        int indexData = linkedListOperation.get(node1,2);
        System.out.println("Element at this index ? " + indexData);

        ListNode node = null;
        node = linkedListOperation.add(node,42);
        linkedListOperation.add(node, 23);
        linkedListOperation.add(node,35);
        linkedListOperation.add(node, -7);
        linkedListOperation.printData(node);
        node = linkedListOperation.addFirst(node, 99);
        linkedListOperation.printData(node);
        node = linkedListOperation.removeFirst(node);
        linkedListOperation.printData(node);
        node = linkedListOperation.remove(node,2);
        linkedListOperation.printData(node);


        ListNode list1 = new ListNode(10);
        list1.next = new ListNode(20);
        ListNode list2 = new ListNode(30);
        list2.next = new ListNode(40);

        System.out.println("List data ?");
        ListNode list1temp = list1.next;
        ListNode list2Temp = list2.next;
        list1.next = list2;
        list2.next = list1temp;
        System.out.println(list1.next.data);
        System.out.println(list1.data);
        list2 = list2Temp;
        System.out.println(list2.data);

    }
}
