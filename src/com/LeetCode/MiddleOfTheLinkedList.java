package com.LeetCode;

class ListNodess {
    int val;
    ListNodess next;
    ListNodess() {

    }
    ListNodess(int val) {
        this.val = val;
    }
    ListNodess(int val, ListNodess next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public ListNodess getNext()
    {
        return next;
    }
}

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNodess head = null;
        head = insertBegining(head, 5);
        head = insertBegining(head, 4);
        head = insertBegining(head, 3);
        head = insertBegining(head, 2);
        head = insertBegining(head, 1);
        System.out.println(toString(middleNode(head)));
    }

    private static ListNodess insertBegining(ListNodess head, int value) {
        ListNodess temp = new ListNodess(value);
        temp.next = head;
        return temp;
    }

    private static String toString(ListNodess head) {
        StringBuilder retStr = new StringBuilder();

        ListNodess current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();

        }

        return retStr.toString();
    }

    private static ListNodess middleNode(ListNodess head) {
        ListNodess slow = head;
        ListNodess fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
