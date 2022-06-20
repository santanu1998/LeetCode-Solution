package com.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    /*
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> myDataStructure = new ArrayList<>();
        boolean[] frequency = new boolean[nums.length];
        recursivePermutation(nums, myDataStructure, result, frequency);
        return result;
    }

    private static void recursivePermutation(int[] nums, List<Integer> myDataStructure, List<List<Integer>> result, boolean[] frequency) {
        if (myDataStructure.size() == nums.length) {
            result.add(new ArrayList<>(myDataStructure));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!frequency[i]) {
                frequency[i] = true;
                myDataStructure.add(nums[i]);
                recursivePermutation(nums, myDataStructure, result, frequency);
                myDataStructure.remove(myDataStructure.size() - 1);
                frequency[i] = false;
            }
        }
    }
    */

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursivePermutation(0, nums, result);
        return result;
    }

    private static void recursivePermutation(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> myDataStructure = new ArrayList<>();
            for (int num : nums) {
                myDataStructure.add(num);
            }
            result.add(new ArrayList<>(myDataStructure));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recursivePermutation(index + 1, nums, result);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
