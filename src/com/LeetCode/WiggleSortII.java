package com.LeetCode;

import java.util.Arrays;

public class WiggleSortII {
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void wiggleSort(int[] nums) {
        int size = nums.length;
        int[] resultArray = new int[size];
        Arrays.sort(nums);
        int left = 1;
        int right = size - 1;
        while (left < size) {
            resultArray[left] = nums[right];
            left += 2;
            right--;
        }
        left = 0;
        while (left < size) {
            resultArray[left] = nums[right];
            left += 2;
            right--;
        }
        for (int k = 0; k < size; k++) {
            nums[k] = resultArray[k];
        }
    }
}
