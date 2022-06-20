package com.LeetCode;

import java.util.Scanner;

public class SmallestRangeI {
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
        int[] nums = {1, 3, 6};
        int k = 3;
        int result = smallestRangeI(nums, k);
        System.out.println(result);
    }

    private static int smallestRangeI(int[] nums, int k) {
        int max_val = nums[0];
        int min_val = nums[0];
        for (int num : nums) {
            min_val = Math.min(num, min_val);
            max_val = Math.max(num, max_val);
        }
        if (min_val + k >= max_val - k) {
            return 0;
        }
        else {
            return (max_val - k) - (min_val + k);
        }
    }
}
