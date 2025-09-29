package august.learn;

public class CircularLinkedList<E> {

    private class Node<E> {
        private Node<E> next;
        private E element;

        public Node(E e, Node<E> n){
            element = e;
            next = n;
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

    private Node<E> tail = null;
    private int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public void addFirst(E element){
        if(tail == null){
            tail = new Node<>(element, null);
            tail.setNext(tail); //link to itself circularly
        }else{
            Node<E> head = new Node<>(element,tail.getNext());
            tail.setNext(head);
        }
        size++;
    }

    public void rotate(){
        if(tail != null)
            tail = tail.getNext();
    }

    public void addLast(E element){

       addFirst(element);
       rotate();
    }

    public E removeFirst(){
       if(isEmpty()) return null;
       Node<E> removeNode = tail.getNext();
       if(removeNode == tail) tail =null;
       else{
           tail.setNext(removeNode.getNext());
       }
       size--;
       return removeNode.getElement();

    }

}
