package com.GeeksForGeeks.Array;

import java.util.HashSet;

public class IntersectionOfTwoArrays {
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
        int[] arr1 = { 1, 3, 2, 3, 4, 5, 5, 6 };
        int[] arr2 = { 3, 3, 5 };
        int result = findIntersection(arr1, arr2);
        System.out.println(result);
    }

    // 1. First Approach (When elements in the array may not be distinct)
    /*
    private static void findIntersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] > arr2[j]) {
                j++;
            }

            else if (arr2[j] > arr1[i]) {
                i++;
            }
            else {
                // when both are equal
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }
    */

    // 2. Second Approach Using HashSet. It is efficient.
    private static int findIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        for (int element : arr1) {
            hs.add(element);
        }
        for (int value : arr2) {
            if (hs.contains(value)) {
                return arr2.length;
            }
        }
        return -1;
    }
}
