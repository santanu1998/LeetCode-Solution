package com.LeetCode;

public class PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        int[] nums = {5, 0, 3, 8, 6};
        int answer = partitionDisjoint(nums);
        System.out.println(answer);
    }

    // 1. First Approach
    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(n)

    /*private static int partitionDisjoint(int[] nums) {
        int length = nums.length;
        int[] rightMinimumArray = new int[length + 1];
        rightMinimumArray[length] = Integer.MAX_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            rightMinimumArray[i] = Math.min(rightMinimumArray[i + 1], nums[i]);
        }
        int leftMaximum = Integer.MIN_VALUE;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            leftMaximum = Math.max(leftMaximum, nums[i]);
            if (leftMaximum <= rightMinimumArray[i + 1]) {
                answer = i;
                break;
            }
        }
        return answer + 1;
    }*/

    // 2. Second Approach
    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(1)

    private static int partitionDisjoint(int[] nums) {
        int leftMaximum = nums[0];
        int greaterElement = nums[0];
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > greaterElement) {
                greaterElement = nums[i];
            }
            else if (nums[i] < leftMaximum) {
                leftMaximum = greaterElement;
                answer = i;
            }
        }
        return answer + 1;
    }

}
