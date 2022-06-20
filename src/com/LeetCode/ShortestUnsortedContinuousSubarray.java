package com.LeetCode;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int answer = findUnsortedSubarray(nums);
        System.out.println(answer);
    }
    private static int findUnsortedSubarray(int[] nums) {
        int endingIndex = -1;
        int maximum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maximum > nums[i]) {
                endingIndex = i;
            }
            else {
                maximum = nums[i];
            }
        }
        int startingIndex = 0;
        int minimum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > minimum) {
                startingIndex = i;
            }
            else {
                minimum = nums[i];
            }
        }
        return (endingIndex - startingIndex + 1);
    }
}
