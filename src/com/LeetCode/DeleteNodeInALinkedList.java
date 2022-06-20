package com.LeetCode;

class SpecialListNode {
    int val;
    SpecialListNode next;
    SpecialListNode() {

    }
    SpecialListNode(int val) {
        this.val = val;
    }
    SpecialListNode(int val, SpecialListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public SpecialListNode getNext()
    {
        return next;
    }
}

public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        SpecialListNode l1 = null;
        SpecialListNode l2 = null;

        l1 = insertBegining(l1, 9);
        l1 = insertBegining(l1, 1);
        l1 = insertBegining(l1, 4);
        l1 = insertBegining(l1, 5);

//        l2 = insertBegining(l2, 5);

        deleteNode(l1);

        System.out.println(toString(l1));
    }
    private static SpecialListNode insertBegining(SpecialListNode head, int value) {
        SpecialListNode temp = new SpecialListNode(value);
        temp.next = head;
        return temp;
    }
    private static String toString(SpecialListNode head) {
        StringBuilder retStr = new StringBuilder();
        SpecialListNode current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();

        }
        return retStr.toString();
    }
    private static void deleteNode(SpecialListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
