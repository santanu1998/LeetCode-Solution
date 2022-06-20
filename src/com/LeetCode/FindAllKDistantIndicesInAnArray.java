package com.LeetCode;

import java.util.*;

public class FindAllKDistantIndicesInAnArray {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int key = scanner.nextInt();
        int k = scanner.nextInt();
        */
        int[] nums = {3, 4, 9, 1, 3, 9, 5};
        int key = 9;
        int k = 1;
        List<Integer> ans = findKDistantIndices(nums, key, k);
        /*
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
        */
        System.out.print(ans);
    }

    private static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        // int n = nums.length;
        // List<Integer> list = new ArrayList<>();
        // Set<Integer> set = new HashSet<>();
        // for (int j = 0; j < n; j++) {
        //     if (nums[j] == key) {
        //         list.add(j);
        //     }
        // }
        // for (int i = 0; i < n; i++) {
        //     for (int j : list) {
        //         if (Math.abs(i - j) <= k && nums[j] == key) {
        //             set.add(i);
        //         }
        //     }
        // }
        // List<Integer> ans = new ArrayList<>(set);
        // Collections.sort(ans);
        // return ans;

        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int from = 0, till = 0;
                //just initialising you could do anything with it;
                from = Math.max((i - k), 0);
                till = Math.min((i + k), nums.length - 1);
                for (int j = from; j <= till; j++)
                    set.add(j);
            }
        }
        for (int i : set)
            list.add(i);
        Collections.sort(list);
        return list;
    }
}
