package com.LeetCode;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] squaredNums = sortedSquares(nums);
        System.out.println(Arrays.toString(squaredNums));
    }

    private static int[] sortedSquares(int[] nums) {

        // First Approach

        // for(int i=0;i<nums.length;i++) {
        //     nums[i]=nums[i]*nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;

        // Second Approch

        int[] squaredNums = new int[nums.length];
        int low = 0;
        int high = nums.length - 1;
        int index = high;
        while (low <= high) {
            if (Math.abs(nums[low]) >= Math.abs(nums[high])) {
                squaredNums[index] = nums[low] * nums[low];
                index--;
                low++;
            }
            else {
                squaredNums[index] = nums[high] * nums[high];
                index--;
                high--;
            }
        }
        return squaredNums;
    }
}
