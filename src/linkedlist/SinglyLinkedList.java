package linkedlist;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public void setNext(Node<E> nextNode) {
            next = nextNode;
        }

        public Node<E> getNext() {
            return next;
        }

        public E getElement() {
            return element;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){
        //constructs initially an empty list
    }
    public int size(){return size;}
    public boolean isEmpty(){
        return size == 0;
    }
    public E first(){
       if(isEmpty()) return null;
       return head.getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    public void addFirst(E firstElement){
        head = new Node<E>(firstElement, head);
        if(isEmpty()) tail = head;
        size++;
    }
    public void addLast(E lastElement){
        Node newNode = new Node<>(lastElement, null);
        if (isEmpty()) head = newNode;
        else tail.setNext(newNode);
        tail = newNode;
        size++;
    }
    public E removeFirst(){
        if(isEmpty()) return null;
        E removedElement = head.getElement();
        head =  head.getNext();
        size--;
        if(size == 0) tail = null;
        return removedElement;
    }
    public void print(){
        Node print = head;
        System.out.println("Elements in the linkedlist ? ");
        while(print != null){
            System.out.println(print.element);
            print = print.next;
        }
    }

}
