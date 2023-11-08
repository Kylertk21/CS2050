package pack0;

public class MyLinkedList {
    private Node head;
    private Node tail;

    static class Node {
        String data;
        Node next;

        Node(String input) {
            data = input;
            next = null;
        }
    }

    public void push(String data) {
        Node insert = new Node(data);
        if (head == null) {
            head = insert;
            tail = insert;
        } else {
            tail.next = insert;
            tail = insert;
        }
    }

    public String pop() {
        if (head == null) {
            System.out.println("List empty");
            return null;
        }

        String popped = head.data;
        head = head.next;
        return popped;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    public String peek() {
        if (head == null) {
            System.out.println("Empty Head");
            return null;
        } else {
            return head.data;
        }
    }

    public void remove() {
        head.data = null;
    }
}
