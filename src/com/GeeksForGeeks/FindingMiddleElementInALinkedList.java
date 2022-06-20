package com.GeeksForGeeks;

class MyNode {
    int data;
    MyNode next;
    MyNode(int key) {
        data = key;
        next = null;
    }
}

public class FindingMiddleElementInALinkedList {
    public static Node head;

    public static void main(String[] args) {
        MyNode head = null;
        head = insertBegining(head, 5);
        head = insertBegining(head, 4);
        head = insertBegining(head, 3);
        head = insertBegining(head, 2);
        head = insertBegining(head, 1);

        int result = getMiddle(head);
        System.out.println(result);
    }

    private static MyNode insertBegining(MyNode head, int value) {
        MyNode temp = new MyNode(value);
        temp.next = head;
        return temp;
    }
    private static void printList(MyNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    private static int getMiddle(MyNode head) {
        MyNode slow = head;
        MyNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
