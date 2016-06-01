package com.komdas.asd.queue;

import com.komdas.asd.linkedlist.SingleLinkedList;

public class Queue {

    private SingleLinkedList list;

    public Queue() {
        list = new SingleLinkedList();
    }

    public void enqueue(Object data) {
        list.addLast(data);
    }

    public Object dequeue() {
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }

    public void print() {
        list.print();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(90);
        q.enqueue(34);
        q.print();
        System.out.printf("\nData dequeued : %s\n", q.dequeue());
        q.print();
        q.enqueue(90);
        q.print();
        System.out.printf("\nData dequeued : %s\n", q.dequeue());
        q.print();
    }

}
