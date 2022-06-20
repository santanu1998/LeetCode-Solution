package com.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        */
        int[] nums = {1, 4, -2, -8, 3, 7, 9};
        int result = firstMissingPositive(nums);
        System.out.println(result);
    }

    // 1. First Approach
    /*
    private static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int j = 1;
        for (int num : nums) {
            if (num == j) {
                j++;
            }
        }
        return j;
        // Time Complexity is : O(n)
        // Auxiliary Space Complexity is : O(1)
    }
    */

    // 2. Second Approach
    /*
    private static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            if (j != nums[i]) {
                if (i == nums.length - 1) {
                    break;
                }
            }
            else {
                j++;
            }
        }
        return j;
        // Time Complexity is : O(n)
        // Auxiliary Space Complexity is : O(1)
    }
    */

    // 3. Third Approach Using Cyclic Sort
    private static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            else {
                i++;
            }
        }
        i = 0;
        while ((i < nums.length && nums[i] == i + 1)) {
            i++;
        }
        return  i+ 1;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    // Time Complexity is : O(n)
    // Auxiliary Space Complexity is : O(1)
}
