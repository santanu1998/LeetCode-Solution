package com.LeetCode;

import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wigleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void wigleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1])) {
                swap(nums, i, i - 1);
            }
        }
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
