package com.komdas.asd.stack;

import java.util.Arrays;

public class Stack {

    private Object[] data;
    private int top;

    public Stack(int n) {
        this.top = -1;
        this.data = new Object[n];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top >= data.length - 1);
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
        for (int i = top; i >= 0; i--) {
            if (data[i] != null) {
                System.out.println(data[i]);
            }
        }
    }

    public String toString() {
        return String.format("{stack_data=%s, top=%d}", Arrays.toString(data), top);
    }

}
