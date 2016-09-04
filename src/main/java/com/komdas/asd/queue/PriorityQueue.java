package com.komdas.asd.queue;

public class PriorityQueue {

    class Node {
        int priority;
        Object data;
        Node next, prev;

        Node(int priority, Object data, Node next, Node prev) {
            this.priority = priority;
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public String toString() {
            return String.format("{priority=%d, data=%s}", priority, data);
        }
    }

    private Node head, tail;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int priority, Object data) {
        if (isEmpty()) {
            Node newest = new Node(priority, data, null, null);
            head = tail = newest;
        } else {
            Node newest = new Node(priority, data, null, null);

            if (newest.priority > head.priority) {
                newest.prev = null;
                newest.next = head;
                head.prev = newest;
                head = newest;
            } else if (newest.priority < tail.priority) {
                newest.next = null;
                newest.prev = tail;
                tail.next = newest;
                tail = newest;
            } else {
                Node pointer = tail;
                while (pointer != null) {
                    if (pointer.priority == newest.priority) {
                        if (pointer == tail) {
                            newest.next = null;
                            newest.prev = tail;
                            tail.next = newest;
                            tail = newest;
                        } else {
                            newest.next = pointer.next;
                            pointer.next.prev = newest;
                            newest.prev = pointer;
                            pointer.next = newest;
                        }
                        break;
                    }
                    pointer = pointer.prev;
                }
            }
        }
        size++;
    }

    public Node dequeue() {
        Node removed = new Node(head.priority, head.data, null, null);
        head = head.next;
        head.prev = null;
        size--;

        return removed;
    }

    public void print() {
        Node p = head;
        while (p != null) {
            System.out.println(p);
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(1, "Anas");
        pq.print();
        pq.enqueue(2, "Charlie");
        pq.print();
        pq.enqueue(2, "Zulu");
        pq.print();
        pq.enqueue(3, "Echo");
        pq.print();
        pq.enqueue(1, "Nike");
        pq.print();
        pq.enqueue(2, "Zeus");
        pq.print();
        pq.dequeue();
        pq.print();
    }

}
