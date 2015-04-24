package com.soul.other;

/**
 * Created by soul on 2015-04-15.
 */
public class Stack {
    private Object[] stack;

    private int top = -1;
    private int size = 0;

    public Stack(int size) {
        this.stack = new Object[size];
        this.size = size;
    }

    public void push(Object value) {
        if (top >= size - 1) { // 사이즈를 넘어가면
            throw new StackOverflowError();
        }
        stack[++top] = value;
    }

    public Object pop() {
        if (top <= 0) return null;
        return stack[top--];
    }
}
