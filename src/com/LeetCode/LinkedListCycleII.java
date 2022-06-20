package com.LeetCode;

class MyNode {
    int val;
    MyNode next;
    MyNode() {

    }
    MyNode(int val) {
        this.val = val;
    }
    MyNode(int val, MyNode next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public MyNode getNext()
    {
        return next;
    }
}

public class LinkedListCycleII {
    public static void main(String[] args) {
        MyNode head = null;
        head = insertBegining(head, 10);
        head = insertBegining(head, 9);
        head = insertBegining(head, 8);
        head = insertBegining(head, 7);
        head = insertBegining(head, 6);
        head = insertBegining(head, 5);
        head = insertBegining(head, 4);
        head = insertBegining(head, 3);
        head = insertBegining(head, 2);
        head = insertBegining(head, 1);

        System.out.println(toString(deleteCycle(head)));
    }
    private static MyNode insertBegining(MyNode head, int value) {
        MyNode temp = new MyNode(value);
        temp.next = head;
        return temp;
    }
    private static String toString(MyNode head) {
        StringBuilder retStr = new StringBuilder();
        MyNode current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return retStr.toString();
    }
    private static MyNode deleteCycle(MyNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        MyNode slowNode = head;
        MyNode fastNode = head;
        MyNode entryNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                while (slowNode != entryNode) {
                    slowNode = slowNode.next;
                    entryNode = entryNode.next;
                }
                return entryNode;
            }
        }
        return null;
    }
}
