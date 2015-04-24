package com.soul.skp;

/**
 * LinkedList를 역으로 하기 위한 클래스이다.
 */
public class ReverseLinkedList {
    Node head;

    class Node {
        String name;
        Object data;
        Node next;

        Node(Object data) {
            this.name = String.valueOf(data);
            this.data = data;
        }
    }

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node tailNode = head;
            while (tailNode.next != null) {
                tailNode = tailNode.next;
            }

            tailNode.next = new Node(data);
        }
    }

    public Node recursiveReverse(Node nextNode) {
        if (nextNode == null || nextNode.next == null) {
            return nextNode;
        }

        Node reverse = recursiveReverse(nextNode.next);
        nextNode.next.next = nextNode;
        nextNode.next = null;

        return reverse;
    }

    public void reverse() {
        head = recursiveReverse(head);
    }

    public void print() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.add(1);
        reverseLinkedList.add(2);
        reverseLinkedList.add(3);

        reverseLinkedList.print();

        reverseLinkedList.reverse();
        reverseLinkedList.print();

        reverseLinkedList.reverse();
        reverseLinkedList.print();
    }
}