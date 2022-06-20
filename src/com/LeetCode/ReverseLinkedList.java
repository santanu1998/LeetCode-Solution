package com.LeetCode;

class ListNode {
      int val;
      ListNode next;
      ListNode() {

      }
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }

    public int getData()
    {
        return val;
    }
    public ListNode getNext()
    {
        return next;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = null;
        head = insertBegining(head, 5);
        head = insertBegining(head, 4);
        head = insertBegining(head, 3);
        head = insertBegining(head, 2);
        head = insertBegining(head, 1);
        System.out.println(toString(reverseNode(head)));
    }

    private static ListNode insertBegining(ListNode head, int value) {
        ListNode temp = new ListNode(value);
        temp.next = head;
        return temp;
    }

    private static String toString(ListNode head) {
        StringBuilder retStr = new StringBuilder();

        ListNode current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();

        }

        return retStr.toString();
    }

    private static ListNode reverseNode(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
