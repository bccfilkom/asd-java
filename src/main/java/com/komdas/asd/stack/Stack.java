package com.komdas.asd.stack;

public class Stack {

    private Object[] data;
    private int top;

    public Stack(int n) {
    	this.top = -1;
        this.data = new Object[n];
    }

    public boolean isEmpty() {
    	return (top == -1) ? true : false;
    }

    public boolean isFull() {
    	return (top >= data.length - 1) ? true : false;
    }

    public void push(Object newData) {
    	if (!isFull()) {
    		data[++top] = newData;
    	} else {
    		throw new IllegalArgumentException("Stack telah penuh");
    	}
    }

    public Object pop() {
    	return (!isEmpty()) ? data[top--] : null;
    }

    public void print() {
    	for (int i = top ; i >= 0 ; i--) {
    		if (data[i] != null) {
    			System.out.println(data[i]);
    		}
    	}
    }

}
