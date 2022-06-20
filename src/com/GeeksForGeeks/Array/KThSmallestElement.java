package com.GeeksForGeeks.Array;

import java.util.Arrays;
import java.util.Scanner;

public class KThSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        */
//        Integer[] arr = {7, 10, 4, 3, 20, 15, 60, 80};
        int[] arr = {7, 10, 4, 3, 20, 15, 60, 80};
        int k = 2;
        int ans = findKThLargestElement(arr, k);
        System.out.println(ans);

        /*
        qSort(arr, 0, arr.length - 1);
        printArray(arr);
        */
        /*
        int ans = findKThSmallestElement(arr, 0, arr.length - 1, k);
        System.out.println(ans);
        */
    }


    /*
    private static int findKThSmallestElement(Integer[] arr, int k) {
        Arrays.sort(arr, Collections.reverseOrder());
        return arr[k - 1];
    }
    */
    private static int findKThLargestElement(int[] arr, int k) {
        /*
        int l = 0;
        int h = arr.length - 1;
        qSort(arr, l, h);
        return arr[k - 1];
        */
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    /*
    private static void qSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = lomutoPartition(arr, l, h);
            qSort(arr, l, pivot);
            qSort(arr, pivot + 1, h);
        }
    }

    private static int lomutoPartition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l;
        for (int j = l + 1; j <= h; j++) {
            if (arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[l];
        arr[l] = temp;
        return i;
    }
    */
/*    public static int findKThSmallestElement(int[] arr, int l, int r, int k)
    {
        //Your code here
        // Arrays.sort(arr);
        // return arr[k - 1];
        qSort(arr, l , r);
        return arr[k - 1];
    }
    public static void qSort(int[] arr, int l, int r) {
        if(l < r) {
            int pivot = lomutoPartition(arr, l , r);
            qSort(arr, l, pivot - 1);
            qSort(arr, pivot + 1, r);
        }
    }
    public static int lomutoPartition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for(int j = l; j <= r - 1; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }*/
/*    public static void printArray(int[] arr) {
        for(int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }*/
}
