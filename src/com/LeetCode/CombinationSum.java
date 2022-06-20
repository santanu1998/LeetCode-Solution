package com.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        List<List<Integer>> ans = combinationSum(candidates, target);
        System.out.println(ans);
    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findAllPossibleCombinations(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private static void findAllPossibleCombinations(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> myDataStructure) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(myDataStructure));
            }
            return;
        }
        if (candidates[index] <= target) {
            myDataStructure.add(candidates[index]);
            findAllPossibleCombinations(index, candidates, target - candidates[index], result, myDataStructure);
            myDataStructure.remove(myDataStructure.size() - 1);
        }
        findAllPossibleCombinations(index + 1, candidates, target, result, myDataStructure);
    }
}
