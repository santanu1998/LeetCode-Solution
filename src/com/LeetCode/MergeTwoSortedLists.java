package com.LeetCode;

class MyListNode {
    int val;
    MyListNode next;
    MyListNode() {

    }
    MyListNode(int val) {
        this.val = val;
    }
    MyListNode(int val, MyListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getData()
    {
        return val;
    }
    public MyListNode getNext()
    {
        return next;
    }
}

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        MyListNode list1 = null;

        MyListNode list2 = null;

        list1 = insertBegining(list1, 4);
        list1 = insertBegining(list1, 2);
        list1 = insertBegining(list1, 1);

        list2 = insertBegining(list2, 4);
        list2 = insertBegining(list2, 3);
        list2 = insertBegining(list2, 1);

        System.out.println(toString(mergeTwoLists(list1, list2)));
    }

    private static MyListNode insertBegining(MyListNode head, int value) {
        MyListNode temp = new MyListNode(value);
        temp.next = head;
        return temp;
    }

    private static String toString(MyListNode head) {
        StringBuilder retStr = new StringBuilder();

        MyListNode current = head;
        while (current != null) {
            retStr.append(current.getData()).append(" ");
            current = current.getNext();

        }

        return retStr.toString();
    }

    private static MyListNode mergeTwoLists(MyListNode list1, MyListNode list2) {
        // iterative approach
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            MyListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        MyListNode result = list1;
        while (list1 != null && list2 != null) {
            MyListNode temp = null;
            while (list1 != null && list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            }
            temp.next = list2;
            // swaping
            MyListNode myTemp = list1;
            list1 = list2;
            list2 = myTemp;
        }
        return result;
    }
}
