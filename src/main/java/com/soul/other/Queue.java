package com.soul.other;

/**
 * Queue 설명 : http://ljsk139.blog.me/30165800034
 */
public class Queue {
    private Object[] queue;
    private int size;
    private int front;
    private int rear;

    Queue(int size) {
        this.size = size;
        this.rear = -1;
        this.queue = new Object[size];
    }

    public boolean isEmpty() {
        return (front == rear + 1);
    }

    public boolean isFull() {
        return (rear == size - 1);
    }

    public void put(Object item) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException();
        queue[++rear] = item;
    }

    /**
     * Queue에서 데이터 조회
     *
     * @return
     */
    public Object peek() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException();
        return queue[front];
    }

    public Object get() {
        front++;
        return peek();
    }
}
