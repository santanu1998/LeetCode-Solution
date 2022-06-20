package com.LeetCode;

class MyNewNode {
    int val;
    MyNewNode next;
    MyNewNode() {

    }
    MyNewNode(int val) {
        this.val = val;
    }
    MyNewNode(int val, MyNewNode next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public MyNewNode getNext()
    {
        return next;
    }
}

public class RotateList {
    public static void main(String[] args) {
        MyNewNode head = null;

        head = insertBegining(head, 5);
        head = insertBegining(head, 4);
        head = insertBegining(head, 3);
        head = insertBegining(head, 2);
        head = insertBegining(head, 1);

        int k = 2;

        System.out.println(toString(rotateRight(head, k)));
    }
    private static MyNewNode insertBegining(MyNewNode head, int value) {
        MyNewNode temp = new MyNewNode(value);
        temp.next = head;
        return temp;
    }
    private static String toString(MyNewNode head) {
        StringBuilder retStr = new StringBuilder();
        MyNewNode current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return retStr.toString();
    }
    private static MyNewNode rotateRight(MyNewNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        MyNewNode currentNode = head;
        int length = 1;
        while (currentNode.next != null) {
            length++;
            currentNode = currentNode.next;
        }
        currentNode.next = head;
        k = length - k % length;
        while (k-- > 0) {
            currentNode = currentNode.next;
        }
        head = currentNode.next;
        currentNode.next = null;
        return head;
    }
}
