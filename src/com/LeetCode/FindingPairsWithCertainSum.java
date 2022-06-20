package com.LeetCode;

import java.util.HashMap;
import java.util.Scanner;

public class FindingPairsWithCertainSum {
    static HashMap<Integer, Integer> map1;
    static HashMap<Integer, Integer> map2;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = scanner.nextInt();
        }
        FindingPairsWithCertainSum findingPairsWithCertainSum = new FindingPairsWithCertainSum(nums1, nums2);
        int index = scanner.nextInt();
        int val = scanner.nextInt();
        findingPairsWithCertainSum.add(index, val);
        int result = findingPairsWithCertainSum.count(index);
    }
    public FindingPairsWithCertainSum(int[] nums1, int[] nums2) {
         map1 = new HashMap<>();
         map2 = new HashMap<>();
         arr = new int[nums2.length];
         for(int i = 0; i < nums1.length; i++)
             map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
         for(int i = 0; i < nums2.length; i++)
             map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
         arr = nums2;
     }

     public void add(int index, int val) {
         map2.put(arr[index], map2.get(arr[index]) - 1);
         arr[index] += val;
         map2.put(arr[index], map2.getOrDefault(arr[index], 0) + 1);
     }

     public int count(int tot) {
         int ans = 0;
         for(int key : map1.keySet()) {
         	int tar = tot - key;
         	ans += map1.get(key) * map2.getOrDefault(tar, 0);
         }
         return ans;
     }
}
