package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetsII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        findAllSubsets(0, nums, new ArrayList<>(), resultList);
        return resultList;
    }

    private static void findAllSubsets(int index, int[] nums, ArrayList<Integer> myOwnDataStructure, List<List<Integer>> resultList) {
        resultList.add(new ArrayList<>(myOwnDataStructure));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            myOwnDataStructure.add(nums[i]);
            findAllSubsets(i + 1, nums, myOwnDataStructure, resultList);
            myOwnDataStructure.remove(myOwnDataStructure.size() - 1);
        }
    }
}
