package com.LeetCode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] answer = productExceptSelf(nums);
        System.out.println(Arrays.toString(answer));
    }

    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(1)

    private static int[] productExceptSelf(int[] nums) {
        int[] rightProduct = new int[nums.length];
        int totalProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            totalProduct *= nums[i];
            rightProduct[i] = totalProduct;
        }
        totalProduct = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            int leftProduct = totalProduct;
            int productRight = rightProduct[i + 1];
            result[i] = leftProduct * productRight;
            totalProduct *= nums[i];
        }
        result[nums.length - 1] = totalProduct;
        return result;
    }
}
