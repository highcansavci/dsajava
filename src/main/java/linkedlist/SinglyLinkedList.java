package linkedlist;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public SinglyLinkedList() {

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if(isEmpty())
            return null;
        return head.getElement();
    }

    public E last() {
        if(isEmpty())
            return null;
        return tail.getElement();
    }

    public void addFirst(E element) {
        head = new Node<>(element, head);
        if(size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null);
        if(isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        if(isEmpty())
            return null;
        E element = head.getElement();
        head = head.getNext();
        size--;
        if(isEmpty())
            tail = null;
        return element;
    }

    public E removeLast() {
        if(isEmpty())
            return null;
        E element = tail.getElement();
        if(head.equals(tail)) {
            head = null;
            tail = null;
            size--;
            return element;
        }
        Node<E> temp = head;
        while(!temp.getNext().equals(tail)) {
            temp = temp.getNext();
        }
        tail = temp;
        temp.setNext(null);
        size--;
        return element;
    }
}
