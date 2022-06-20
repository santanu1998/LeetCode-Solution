package com.LeetCode;

import java.util.Scanner;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        */
        int[] nums = {3, 1, 3, 4, 2};
        int result = findDuplicate(nums);
        System.out.println(result);
    }

    // 1. Using Linked List Cycle Method
    /*
    private static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
        // Here Time Complexity is : O(n)
        // Here Auxiliary Space Complexity is : O(1)
    }
    */

    // 2. Using Recursion
    /*
    private static int findDuplicate(int[] nums) {
        return dfs(nums, 0);
        // Here Time Complexity is : O(n)
        // Here Auxiliary Space Complexity is : O(1)
    }
    private static int dfs(int[] nums, int i) {
        if (nums[i] == i)
            return nums[i];
        int temp = nums[i];
        nums[i] = i;
        return dfs(nums, temp);
    }
    */

    // 3. Using Hashing Approach
    private static int findDuplicate(int[] nums) {
        int ans = 0;
        int[] hash = new int[nums.length + 1];
        for (int num : nums) {
            hash[num]++;
        }
        for(int i = 1; i < hash.length; i++){
            if(hash[i] >= 2){
                ans = i;
            }
        }
        return ans;
        // Here Time Complexity is : O(n)
        // Here Auxiliary Space Complexity is : O(n)
    }
}
