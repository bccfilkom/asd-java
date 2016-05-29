package com.komdas.asd.linkedlist;

public interface ILinkedList {
	boolean isEmpty();
	void addFirst(Object newData);
	void addLast(Object newData);
	Object removeFirst();
	Object removeLast();
	void print();
	int size();
}