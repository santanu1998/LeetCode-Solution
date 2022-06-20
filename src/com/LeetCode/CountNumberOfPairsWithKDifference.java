package com.LeetCode;

import java.util.HashMap;
import java.util.Scanner;

public class CountNumberOfPairsWithKDifference {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        */
        int[] nums = {1, 2, 2, 1};
        int k = 1;
        int result = countKDifference(nums, k);
        System.out.println(result);
    }

    // Optimization Approach
    private static int countKDifference(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        var count = 0;
        for (var e : nums) {
            count += map.getOrDefault(e - k, 0) + map.getOrDefault(e + k, 0);
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        return count;
        // Time Complexity is : O(n)
        // Auxiliary Space Complexity is : O(n)
    }

    // Brute Force Approach
    /*
    private static int countKDifference(int[] nums, int k) {
         int counter = 0;
         for(int i = 0; i < nums.length; i++) {
             for(int j = i + 1; j < nums.length; j++) {
                 if(Math.abs(nums[j] - nums[i]) == k) {
                     counter++;
                 }
             }
         }
         return counter;
         // Time Complexity is : O(n^2)
        // Auxiliary Space Complexity is : O(1)
    }
    */
}
