package com.GeeksForGeeks.Array;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr1 = new long[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextLong();
        }
        int m = scanner.nextInt();
        long[] arr2 = new long[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextLong();
        }
        */
        long[] arr1 = {1, 3, 5, 7};
        int n = arr1.length;
        long[] arr2 = {0, 2, 6, 8, 9};
        int m = arr2.length;
        merge(arr1, arr2, n, m);
        printArray(arr1, arr2);
    }

    private static void merge(long[] arr1, long[] arr2, int n, int m) {
        long[] temp = new long[n + m];
        int k = 0;
        int l = 0;
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                temp[i] = arr1[k];
                k++;
            }
            else {
                temp[i] = arr2[l];
                l++;
            }
        }
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (i < n) {
                arr1[i] = temp[i];
            }
            else {
                arr2[i - n] = temp[i];
            }
        }
    }

    private static void printArray(long[] arr1, long[] arr2) {
        for (long element : arr1) {
            System.out.print(element + " ");
        }
        for (long value : arr2) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
