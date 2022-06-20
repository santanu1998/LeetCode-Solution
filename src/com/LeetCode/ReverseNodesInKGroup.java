package com.LeetCode;

class Node {
    int val;
    Node next;
    Node() {

    }
    Node(int val) {
        this.val = val;
    }
    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public Node getNext()
    {
        return next;
    }
}

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Node head = null;
        head = insertBegining(head, 8);
        head = insertBegining(head, 7);
        head = insertBegining(head, 6);
        head = insertBegining(head, 5);
        head = insertBegining(head, 4);
        head = insertBegining(head, 3);
        head = insertBegining(head, 2);
        head = insertBegining(head, 1);

        int k = 3;

        System.out.println(toString(reverseKGroup(head, k)));
    }

    private static Node insertBegining(Node head, int value) {
        Node temp = new Node(value);
        temp.next = head;
        return temp;
    }

    private static String toString(Node head) {
        StringBuilder retStr = new StringBuilder();
        Node current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return retStr.toString();
    }
    private static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node currentNode = dummyNode;
        Node nextNode = dummyNode;
        Node previousNode = dummyNode;
        int count = 0;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            count++;
        }
        while (count >= k) {
            currentNode = previousNode.next;
            nextNode = currentNode.next;
            for (int i = 1; i < k; i++) {
                currentNode.next = nextNode.next;
                nextNode.next = previousNode.next;
                previousNode.next = nextNode;
                nextNode = currentNode.next;
            }
            previousNode = currentNode;
            count -= k;
        }
        return dummyNode.next;
    }
}
