package com.LeetCode;

import java.util.*;

public class MaxNumberOfKSumPairs {
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
        int[] arr = {1, 2, 3, 4};
        int k = 5;
        int result = maxOperations(arr, k);
        System.out.println(result);
    }

    // Using HashMap
    /*
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
    */

    // First Approach
    /*
    private static int maxOperations(int[] nums, int k) {

         Map<Integer, Integer> map = new HashMap<>();
         int count = 0;
         for (int element : nums) {
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
    */

    // Second Approach Using Two Pointer

    private static int maxOperations(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int counter = 0;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                left++;
                right--;
                counter++;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return counter;
        // Time Complexity is : O(n)
        // Auxiliary Space Complexity is : O(1)
    }

    // Third Approach Using HashMap
    /*
    private static int maxOperations(int[] nums, int k) {
        int n = 0;
        int size = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
        }
        //System.out.println(hm.keySet().toString());
        for (int i : hs) {
            while (hm.containsKey(i)) {
                int newVal = hm.get(i) - 1;
                hm.put(i, newVal);
                if (newVal == 0) {
                    hm.remove(i);
                }
                if (hm.containsKey(k - i)) {
                    n++;
                    int temp = hm.get(k - i) - 1;
                    hm.put(k - i, temp);
                    if (temp == 0) {
                        hm.remove(k - i);
                    }
                } else {
                    break;
                }
            }
        }
        return n;
        // Time Complexity is : O(n)
        // Auxiliary Space Complexity is : O(1)
    }
    */
}
