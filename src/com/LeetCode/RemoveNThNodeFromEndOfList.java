package com.LeetCode;

class ListNodes {
    int val;
    ListNodes next;
    ListNodes() {

    }
    ListNodes(int val) {
        this.val = val;
    }
    ListNodes(int val, ListNodes next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public ListNodes getNext()
    {
        return next;
    }
}

public class RemoveNThNodeFromEndOfList {
    public static void main(String[] args) {
        ListNodes head = null;
        head = insertBegining(head, 5);
        head = insertBegining(head, 4);
        head = insertBegining(head, 3);
        head = insertBegining(head, 2);
        head = insertBegining(head, 1);
        System.out.println(toString(removeNthFromEnd(head, 2)));
    }

    private static ListNodes insertBegining(ListNodes head, int value) {
        ListNodes temp = new ListNodes(value);
        temp.next = head;
        return temp;
    }

    private static String toString(ListNodes head) {
        StringBuilder retStr = new StringBuilder();

        ListNodes current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();

        }

        return retStr.toString();
    }

    private static ListNodes removeNthFromEnd(ListNodes head, int n) {
        ListNodes first = head;
        ListNodes second = head;
        for (int i = 0; i < n; i++) {
            if (second.next == null) {
                if (i == n - 1) {
                    head = head.next;
                }
                return head;
            }
            second = second.next;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}
