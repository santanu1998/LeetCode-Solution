package com.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestRangeII {
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
        int result = smallestRangeII(nums, k);
        System.out.println(result);
    }

    private static int smallestRangeII(int[] nums, int k) {
        if(nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int minLeft = nums[0] + k;
        int maxRight = nums[nums.length - 1] - k;

        int res = nums[nums.length - 1] - nums[0];

        for(int i = 0; i < nums.length - 1; i++) {
            int minLocal = Math.min(minLeft, nums[i + 1] - k);
            int maxLocal = Math.max(nums[i] + k, maxRight);
            res = Math.min(res, maxLocal - minLocal);
        }
        return res;
    }
}
