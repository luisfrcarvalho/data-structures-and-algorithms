package LinkedLists;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node head;

    private Node tail;

    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void addLast(int value) {
        var node = new Node(value);

        if(isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void addFirst(int value) {
        var node = new Node(value);

        if(isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public int indexOf(int value) {

        var index = 0;
        var currentNode = head;
        while(currentNode != null) {
            if(currentNode.getValue() == value) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        }

        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) > -1;
    }

    public void removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException();

        if(head == tail) {
            head = tail = null;
        } else {
            var next = this.head.getNext();
            this.head.setNext(null);
            this.head = next;
        }
        size--;
    }

    public void removeLast() {
        if(isEmpty())
            throw new NoSuchElementException();

        var currentNode = head;

        while(currentNode.getNext() != tail) {
            currentNode = currentNode.getNext();
        }

        if(head == tail) {
            head = tail = null;
        } else {
            this.tail = currentNode;
            this.tail.setNext(null);
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public int[] toArray() {
        var current = head;
        int[] array = new int[this.size];
        var index = 0;

        while(current != null) {
            array[index] = current.getValue();
            current = current.getNext();
            index++;
        }

        return array;
    }

    public void reverse() {
        if(isEmpty())
            return;

        Node previous = this.head;
        Node current = this.head.getNext();
        while(current != null) {
            var next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        this.tail = this.head;
        this.tail.setNext(null);
        this.head = previous;
    }
    public Node getTheKthNode(int k) {

        if(k > this.size) {
            throw new IllegalStateException();
        }

        Node a = this.head;
        Node b = this.head;

        for(int i = 0; i < k - 1; i++)
            b = b.getNext();

        while(b != this.tail) {
            a = a.getNext();
            b = b.getNext();
        }

        return a;
    }

}
