package com.GeeksForGeeks.Array;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        */
        int[] arr = {1, 5, 7, 1};
        int k = 6;
        int result = getPairsCount(arr, k);
        System.out.println(result);
    }

    // Using HashMap
    private static int getPairsCount(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int element : arr) {
            if (map.containsKey(k - element)) {
                count += map.get(k - element);
                map.put(element, map.getOrDefault(element, 0) + 1);
            } else {
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
        }
        return count;
        // Time Complexity is : O(n)
        // Auxiliary Space Complexity is : O(1)
    }
}
