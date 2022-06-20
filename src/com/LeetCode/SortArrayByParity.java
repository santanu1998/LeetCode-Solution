package com.LeetCode;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int[] answer = sortArrayByParity(nums);
        System.out.println(Arrays.toString(answer));
    }
    private static int[] sortArrayByParity(int[] nums) {
        sortArrayUsingParity(nums);
        return nums;
    }
    private static void sortArrayUsingParity(int[] nums) {
        int firstPointer = 0;
        int secondPointer = 0;
        while (firstPointer < nums.length) {
            if (nums[firstPointer] % 2 == 0) {
                int temp = nums[firstPointer];
                nums[firstPointer] = nums[secondPointer];
                nums[secondPointer] = temp;
                firstPointer++;
                secondPointer++;
            }
            else {
                firstPointer++;
            }
        }
    }
}
