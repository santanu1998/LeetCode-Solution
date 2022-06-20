package com.GeeksForGeeks.Array;

import java.util.HashMap;
import java.util.Map;

public class UnionOfTwoArrays {
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
        int[] arr1 = {85, 25, 1, 32, 54, 6, 2};
        int[] arr2 = {85, 2, 41, 77};
        int result = findUnion(arr1, arr2);
        System.out.println(result);
    }

    // 2. Using HashMap it is also the efficient approach
    private static int findUnion(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], i);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        return map.size();
        // Time Complexity : O(m+n)
    }

    // 1. Using HashSet efficient approach
    /*
    private static int findUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : arr1) {
            set.add(element);
        }
        for (int value : arr2) {
            set.add(value);
        }
        return set.size();
        // Time Complexity : O(m * log(m) + n * log(n))
    }
    */
}
