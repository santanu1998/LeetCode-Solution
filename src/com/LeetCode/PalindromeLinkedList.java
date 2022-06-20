package com.LeetCode;

class NewSpecialListNode {
    int val;
    NewSpecialListNode next;
    NewSpecialListNode() {

    }
    NewSpecialListNode(int val) {
        this.val = val;
    }
    NewSpecialListNode(int val, NewSpecialListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public NewSpecialListNode getNext()
    {
        return next;
    }
}

public class PalindromeLinkedList {
    public static void main(String[] args) {
        NewSpecialListNode head = null;
        head = insertBegining(head, 2);
        head = insertBegining(head, 1);
        head = insertBegining(head, 1);
        head = insertBegining(head, 2);

        boolean result = isPalindrome(head);
        System.out.println(result);
    }
    private static NewSpecialListNode insertBegining(NewSpecialListNode head, int value) {
        NewSpecialListNode temp = new NewSpecialListNode(value);
        temp.next = head;
        return temp;
    }
    private static String toString(NewSpecialListNode head) {
        StringBuilder retStr = new StringBuilder();
        NewSpecialListNode current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();

        }
        return retStr.toString();
    }
    private static NewSpecialListNode reverseNode(NewSpecialListNode head) {
        NewSpecialListNode currentNode = head;
        NewSpecialListNode previousNode = null;
        while (currentNode != null) {
            NewSpecialListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }
    private static boolean isPalindrome(NewSpecialListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // Find Middle
        NewSpecialListNode slowNode = head;
        NewSpecialListNode fastNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        // Reverse The Right Half
        slowNode.next = reverseNode(slowNode.next);
        // Move SlowNode to Right Half
        slowNode = slowNode.next;
        // Check For The Left Half Right Half Equal Or Not
        while (slowNode != null) {
            if (head.val != slowNode.val) {
                return false;
            }
            head = head.next;
            slowNode = slowNode.next;
        }
        return true;
    }
}
