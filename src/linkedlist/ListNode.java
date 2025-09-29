package linkedlist;

public class ListNode {
    int data;
    ListNode next;
    public ListNode(){}
    public ListNode(int data){
        this.data = data;
    }
    public ListNode(int data, ListNode next){
        this.data = data;
        this.next = next;
    }
}
