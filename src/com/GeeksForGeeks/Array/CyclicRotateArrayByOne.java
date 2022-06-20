package com.GeeksForGeeks.Array;

import java.util.Scanner;

public class CyclicRotateArrayByOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        cyclicRotateByOne(arr);
        printArray(arr);
    }

    // Naive Approach
    private static void cyclicRotateByOne(int[] arr) {
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
        // Time Complexity is : O(n)
        // Auxiliary Space Complexity is : O(1)
    }
    private static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
