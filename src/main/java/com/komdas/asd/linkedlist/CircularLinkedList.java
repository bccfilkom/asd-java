package com.komdas.asd.linkedlist;

public class CircularLinkedList implements ILinkedList {

    class Node {
        Object data;
        Node next;

        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    Node head, tail;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void addFirst(Object newData) {
        Node newest = new Node(newData, null);
        if (isEmpty()) {
            head = newest;
            tail = newest;
            tail.next = head;
        } else {
            tail.next = newest;
            newest.next = head;
            head = newest;
        }
        size++;
    }

    @Override
    public void addLast(Object newData) {
        if (isEmpty()) {
            addFirst(newData);
        } else {
            Node newest = new Node(newData, head);
            tail.next = newest;
            tail = newest;
            size++;
        }
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) return null;

        Object removed = head.data;
        tail.next = head.next;
        head = head.next;
        size--;

        return removed;
    }

    @Override
    public Object removeLast() {
        int count = 0;
        Node pointer = head;
        Object removed = tail.data;

        while (pointer != null) {
            if (count == size() - 2) {
                tail = pointer;
                tail.next = head;
                break;
            }
            count++;
            pointer = pointer.next;
        }

        size--;
        return removed;
    }

    @Override
    public void print() {
        Node pointer = head;

        for (int i = 0 ; i < size() ; i++) {
            System.out.printf("%s->", pointer.data);
            pointer = pointer.next;
        }

        System.out.println();
    }

    public void rotate() {
        if (!isEmpty()) {
            head = head.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addLast(10);
        cll.addLast(20);
        cll.addLast(30);
        cll.print();
        cll.removeFirst();
        cll.print();
        cll.addLast(40);
        cll.print();
        cll.removeLast();
        cll.print();
        cll.addLast(50);
        cll.addLast(60);
        cll.print();
        cll.rotate();
        cll.print();
    }

}
