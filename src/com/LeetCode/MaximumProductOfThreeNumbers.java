package com.LeetCode;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int answer = maximumProduct(nums);
        System.out.println(answer);
    }

    private static int maximumProduct(int[] nums) {
        int minimum1 = Integer.MAX_VALUE;
        int minimum2 = minimum1;
        int maximum1 = Integer.MIN_VALUE;
        int maximum2 = maximum1;
        int maximum3 = maximum1;
        for (int currentValue : nums) {
            if (currentValue >= maximum1) {
                maximum3 = maximum2;
                maximum2 = maximum1;
                maximum1 = currentValue;
            }
            else if (currentValue >= maximum2) {
                maximum3 = maximum2;
                maximum2 = currentValue;
            }
            else if (currentValue >= maximum3) {
                maximum3 = currentValue;
            }
            if (currentValue <= minimum1) {
                minimum2 = minimum1;
                minimum1 = currentValue;
            }
            else if (currentValue <= minimum2) {
                minimum2 = currentValue;
            }
        }
        return Math.max((minimum1 * minimum2 * maximum1), (maximum1 * maximum2 * maximum3));
    }
}
