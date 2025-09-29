package september_learn;

public class ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     * */
      public static class ListNode {
         int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
        public static ListNode reverseList(ListNode head) {

            if(head == null || head.next == null) return head;
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }

    public static void main(String[] args) {

          ListNode head = new ListNode(1);
          head.next = new ListNode(2);
          head.next.next = new ListNode(3);
          head.next.next.next = new ListNode(4);
          head.next.next.next.next = new ListNode(5);
          ListNode res = reverseList(head);
          while(res != null){
              System.out.println(res.val);
              res = res.next;
          }
    }
}
