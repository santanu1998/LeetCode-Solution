package com.LeetCode;

import java.util.Scanner;

public class MaximizeTheTopmostElementAfterKMoves {
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
        int[] nums = {5, 2, 2, 4, 0, 6};
        int k = 4;
        int max = maximumTop(nums, k);
        System.out.println(max);
    }
    private static int maximumTop(int[] nums, int k) {
        if (nums.length == 1 && k % 2 == 1) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < Math.min(k - 1, nums.length); i++) {
            max = Math.max(max, nums[i]);
        }
        if (k < nums.length) {
            max = Math.max(max, nums[k]);
        }
        return max;
    }
}
