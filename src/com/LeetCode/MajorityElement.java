package com.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);
    }

    // 1. Using Moore's Voting Algorithm
    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(1)

    private static int majorityElement(int[] nums) {
        int count = 0;
         int element = 0;
         for (int num : nums) {
             if (count == 0) {
                 element = num;
             }
             if (num == element) {
                 count += 1;
             }
             else {
                 count -= 1;
             }
         }
         return element;
    }

    // 2. Second Approach using HashMap
    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(n)

    /*private static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        int majorityElement = 0;
        int benchMark = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > benchMark) {
                majorityElement = number;
            }
        }
        return majorityElement;
    }*/
}
