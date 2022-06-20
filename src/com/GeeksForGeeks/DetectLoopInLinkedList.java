package com.GeeksForGeeks;

class Nodes {
    int data;
    Nodes next;
    Nodes(int key) {
        data = key;
        next = null;
    }
}

public class DetectLoopInLinkedList {
    public static Nodes head;

    public static void main(String[] args) {
        Nodes head = null;
        head = insertBegining(head, 4);
        head = insertBegining(head, 3);
        head = insertBegining(head, 1);

        int N = 3;
        int x = 2;
        Nodes tail = head;
        makeLoop(head, tail, x);

        boolean result = detectLoop(head);
        System.out.println(result);
    }

    private static Nodes insertBegining(Nodes head, int value) {
        Nodes temp = new Nodes(value);
        temp.next = head;
        return temp;
    }
    private static void printList(MyNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    private static void makeLoop(Nodes head, Nodes tail, int x) {
        if (x == 0) {
            return;
        }
        Nodes current = head;
        for (int i = 1; i < x; i++) {
            current = current.next;
        }
        tail.next = current;
    }
    private static boolean detectLoop(Nodes head) {
        while(head.next != null) {
            if(head.data == 0) {
                return true;
            }
            head.data = 0;
            head = head.next;
        }
        return false;
    }
}
