package com.komdas.asd.linkedlist;

public class SingleLinkedList implements ILinkedList {

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
        } else {
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
            Node newest = new Node(newData, null);
            tail.next = newest;
            tail = newest;
            size++;
        }
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) return null;

        Object removed = head.data;
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
                tail.next = null;
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

        while (pointer != null) {
            System.out.printf("%s->", pointer.data);
            pointer = pointer.next;
        }

        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.addFirst(67);
        sll.addFirst(90);
        sll.addLast(100);
        sll.print();
        sll.removeLast();
        sll.print();
    }

}
