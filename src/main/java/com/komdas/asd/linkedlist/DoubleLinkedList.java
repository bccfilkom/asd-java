package com.komdas.asd.linkedlist;

public class DoubleLinkedList implements ILinkedList {

    class Node {
        Object data;
        Node next, prev;

        Node(Object data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    Node head, tail;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Object newData) {
        if (isEmpty()) {
            Node newest = new Node(newData, null, null);
            head = newest;
            tail = newest;
        } else {
            Node newest = new Node(newData, null, head);
            head.prev = newest;
            head = newest;
        }
        size++;
    }

    @Override
    public void addLast(Object newData) {
        if (isEmpty()) {
            addFirst(newData);
        } else {
            Node newest = new Node(newData, tail, null);
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
        head.prev = null;

        size--;
        return removed;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) return null;

        Object removed = tail.data;
        tail = tail.prev;
        tail.next = null;

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
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addFirst(91);
        dll.addFirst(77);
        dll.print();
        dll.addLast(98);
        dll.print();
        System.out.println("\nData removed : "+dll.removeFirst());
        dll.print();
        dll.addLast(90);
        dll.print();
        System.out.println("\nData removed : "+dll.removeLast());
        dll.print();
    }
}
