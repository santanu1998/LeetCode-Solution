package com.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {1, 2, 3};
        long answer = subArrayRanges(nums);
        System.out.println(answer);
    }

    // 1. First Approach

    /*private static long subArrayRanges(int[] nums) {
        long answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int maximum = Integer.MIN_VALUE;
            int minimum = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                minimum = Math.min(minimum, nums[j]);
                maximum = Math.max(maximum, nums[j]);
                answer += (long) (maximum - minimum);
            }
        }
        return answer;
    }*/

    // 2. Second Approach

     private static long subArrayRanges(int[] nums) {
         return subArraySum(nums, '<') - subArraySum(nums, '>');
     }
     private static long subArraySum(int[] nums, char ch) {
         int length = nums.length;
         long answer = 0;
         int[] previousArray = new int[length];
         int[] nextArray = new int[length];
         Deque<Integer> stack = new ArrayDeque<>();
         Arrays.fill(previousArray, -1);
         Arrays.fill(nextArray, length);
         for (int i = 0; i < length; ++i) {
             while (!stack.isEmpty() && function(ch, nums[stack.peek()], nums[i])) {
                 int index = stack.pop();
                 nextArray[index] = i;
             }
             if (!stack.isEmpty()) {
                 previousArray[i] = stack.peek();
             }
             stack.push(i);
         }
         for (int i = 0; i < length; ++i) {
             answer += (long) nums[i] * (i - previousArray[i]) * (nextArray[i] - i);
         }
         return answer;
     }
     private static boolean function(char ch, int first, int last) {
         if (ch == '<') {
             return first < last;
         }
         return first > last;
     }
}
