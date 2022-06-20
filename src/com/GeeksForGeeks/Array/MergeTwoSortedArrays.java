package com.GeeksForGeeks.Array;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }
        */
        int[] arr1 = { 10, 27, 38, 43, 82 };
        int n = arr1.length;
        int[] arr2 = { 3, 9 };
        int m = arr2.length;
        merge(arr1, arr2);
        for (int element : arr1) {
            System.out.print(element + " ");
        }
        for (int value : arr2) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void merge(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0, k = n - 1;
        while(i <= k && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            }
            else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
