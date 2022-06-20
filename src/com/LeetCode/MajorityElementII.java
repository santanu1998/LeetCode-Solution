package com.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        List<Integer> answer = majorityElement(nums);
        System.out.println(answer);
    }

    // 1. Using Boyer Moore's Voting Algorithms
    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(1)

    /*private static List<Integer> majorityElement(int[] nums) {
         int number1 = -1;
         int number2 = -1;
         int count1 = 0;
         int count2 = 0;
         int length = nums.length;
        for (int num : nums) {
            if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                number2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> answer = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            }
        }
        if (count1 > length / 3) {
            answer.add(number1);
        }
        if (count2 > length / 3) {
            answer.add(number2);
        }
        return answer;
    }*/

    // 2. Using HashMap
    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(n)

    private static List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int x = nums.length / 3;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int count = map.get(num);
                map.put(num, count + 1);
            }
        }
        // iterating through the entry set of hash map
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value > x) {
                list.add(key);
            }
        }
        return list;
    }
}
