package com.LeetCode;

public class FindTriangleSumOfAnArray {
    public static void main(String[] args) {
//        int[] nums = {2,6,6,2,5,7};
        int[] nums = {1,2,3,4,5};
        int ans = triangularSum(nums);
        System.out.println(ans);
    }
    private static int triangularSum(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int i;
        int[] newNums = new int[length - 1];
        while (length > 1) {
            for (i = 0; i < length - 1; i++) {
                newNums[i] = ((nums[i] + nums[i + 1]));
                if (newNums[i] >= 10) {
                    newNums[i] = newNums[i] % 10;
                }
            }
            --length;
            nums = newNums;
        }
        return nums[0];
    }
}
