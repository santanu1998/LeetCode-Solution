package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> finalAnswer = subsets(nums);
        System.out.println(finalAnswer);
    }

    //  1. Iterative Approach
    //  Time Complexity of this solution is : O(n * 2 ^ n)
    //  Auxiliary Space Complexity of this solution is : O(n * 2 ^ n)
    /*
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());
        for (int num : nums) {
            int size = resultList.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temporaryList = new ArrayList<>(resultList.get(i));
                temporaryList.add(num);
                resultList.add(temporaryList);
            }
        }
        return resultList;
    }*/

    //  2. Recursive(Backtracking) Approach
    //  Time Complexity of this solution is : O(n * 2 ^ n)
    //  Auxiliary Space Complexity of this solution is : O(n * 2 ^ n)
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        generatingSubsets(0, nums, new ArrayList<>(), resultList);
        return resultList;
    }
    private static void generatingSubsets(int index, int[] nums, List<Integer> currentList, List<List<Integer>> resultList) {
        resultList.add(new ArrayList<>(currentList));
        for (int i = index; i < nums.length; i++) {
            currentList.add(nums[i]);
            generatingSubsets(i + 1, nums, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
