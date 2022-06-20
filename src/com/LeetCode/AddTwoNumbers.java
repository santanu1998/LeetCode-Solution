package com.LeetCode;

class MyOwnListNode {
    int val;
    MyOwnListNode next;
    MyOwnListNode() {

    }
    MyOwnListNode(int val) {
        this.val = val;
    }
    MyOwnListNode(int val, MyOwnListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public MyOwnListNode getNext()
    {
        return next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        MyOwnListNode l1 = null;

        MyOwnListNode l2 = null;

        l1 = insertBegining(l1, 3);
        l1 = insertBegining(l1, 4);
        l1 = insertBegining(l1, 2);

        l2 = insertBegining(l2, 4);
        l2 = insertBegining(l2, 6);
        l2 = insertBegining(l2, 5);

        System.out.println(toString(addTwoNumbers(l1, l2)));
    }
    private static MyOwnListNode insertBegining(MyOwnListNode head, int value) {
        MyOwnListNode temp = new MyOwnListNode(value);
        temp.next = head;
        return temp;
    }
    private static String toString(MyOwnListNode head) {
        StringBuilder retStr = new StringBuilder();
        MyOwnListNode current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();

        }
        return retStr.toString();
    }
    private static MyOwnListNode addTwoNumbers(MyOwnListNode l1, MyOwnListNode l2) {
        MyOwnListNode myDummyNode = new MyOwnListNode(0);
        MyOwnListNode temporaryNode = myDummyNode;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            temporaryNode.next = new MyOwnListNode(carry % 10);
            carry /= 10;
            temporaryNode = temporaryNode.next;
        }
        return myDummyNode.next;
    }
}
