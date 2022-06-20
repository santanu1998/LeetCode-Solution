package com.GeeksForGeeks;

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

public class ReverseALinkedListInGroupsOfGivenSize {
    public static Node head;

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a1 = scanner.nextInt();
        Node head = new Node(a1);
        Node tail = head;
        for (int i = 1; i < n; i++) {
            int a = scanner.nextInt();
            tail.next = new Node(a);
            tail = tail.next;
        }
        int k = scanner.nextInt();*/
        Node head = null;
        head = insertBegining(head, 8);
        head = insertBegining(head, 7);
        head = insertBegining(head, 6);
        head = insertBegining(head, 5);
        head = insertBegining(head, 4);
        head = insertBegining(head, 2);
        head = insertBegining(head, 2);
        head = insertBegining(head, 1);

        int k = 4;

        Node result = reverse(head, k);
        printList(result);
        System.out.println();
    }
    private static Node insertBegining(Node head, int value) {
        Node temp = new Node(value);
        temp.next = head;
        return temp;
    }
    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    private static Node reverse(Node head, int k) {
        Node resultNode = head;
        Node dummyStartNode = null;
        Node previousNode = null;
        int i = 0;
        while(head != null && i < k){
            dummyStartNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = dummyStartNode;
            i++;
        }
        if(dummyStartNode != null) {
            resultNode.next = reverse(dummyStartNode, k);
        }
        return previousNode;
    }
}
