package august.learn;
public class SinglyLinkedListRoberto<E> {

    private class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }

        public void setNext(Node<E> next){
            this.next = next;
        }

        public Node<E> getNext(){
            return next;
        }

        public E getElement(){
            return element;
        }
    }

    //Instance variable of singly linked list.

    private  Node<E> head = null;
    private Node<E> tail = null;

    int size = 0;

    public SinglyLinkedListRoberto(){}

    //access Methods.
    public int getSize(){
        return size;
    }
    public E getHead(){
        return head.getElement() != null ? head.getElement() : null;
    }
    public E getTail(){
        return tail.getElement() != null? tail.getElement() : null;
    }

    boolean isEmpty(){
        return size ==0;
    }
    //Update Methods.
    public void addFirst(E e){
        head = new Node<>(e, head);
        if(isEmpty()){
            tail = head;
        }
        size = size+1;
    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty()) head = newest;
        else {
            tail.setNext(newest);
            tail = newest;
        }
        size =size +1;
    }

    public E removeFirst(){
        E e = null;
        if(!isEmpty()){
            e = head.getElement();
            head = head.getNext();
            size--;
        }
        if(isEmpty()) tail = null;
        return e;
    }

    public void print(){
        Node<E> printNode = head;
        while (printNode != null){
            System.out.println(printNode.getElement());
            printNode = printNode.getNext();
        }
    }
}
