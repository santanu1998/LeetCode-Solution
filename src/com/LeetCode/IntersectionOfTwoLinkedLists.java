package com.LeetCode;

class MySpecialListNode {
    int val;
    MySpecialListNode next;
    MySpecialListNode() {

    }
    MySpecialListNode(int val) {
        this.val = val;
    }
    MySpecialListNode(int val, MySpecialListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public MySpecialListNode getNext()
    {
        return next;
    }
}

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        MySpecialListNode headA = null;
        MySpecialListNode headB = null;

        headA = insertBegining(headA, 5);
        headA = insertBegining(headA, 4);
        headA = insertBegining(headA, 8);
        headA = insertBegining(headA, 1);
        headA = insertBegining(headA, 4);

        headB = insertBegining(headB, 5);
        headB = insertBegining(headB, 4);
        headB = insertBegining(headB, 8);
        headB = insertBegining(headB, 1);
        headB = insertBegining(headB, 6);
        headB = insertBegining(headB, 5);


        MySpecialListNode result = getIntersectionNode(headA, headB);

        System.out.println(result);
    }
    private static MySpecialListNode insertBegining(MySpecialListNode head, int value) {
        MySpecialListNode temp = new MySpecialListNode(value);
        temp.next = head;
        return temp;
    }
    private static String toString(MySpecialListNode head) {
        StringBuilder retStr = new StringBuilder();
        MySpecialListNode current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();

        }
        return retStr.toString();
    }
    private static MySpecialListNode getIntersectionNode(MySpecialListNode headA, MySpecialListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        MySpecialListNode firstNode = headA;
        MySpecialListNode secondNode = headB;
        while (firstNode != secondNode) {
            firstNode = firstNode == null ? headB : firstNode.next;
            secondNode = secondNode == null ? headA : secondNode.next;
        }
        return firstNode;
    }
}
