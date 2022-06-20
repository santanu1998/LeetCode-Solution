package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumII {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        */
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ans = combinationSumII(candidates, target);
        System.out.println(ans);
    }

    private static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findAllPossibleCombinations(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private static void findAllPossibleCombinations(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> myDataStructure) {
        if (target == 0) {
            result.add(new ArrayList<>(myDataStructure));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            myDataStructure.add(candidates[i]);
            findAllPossibleCombinations(i + 1, candidates, target - candidates[i], result, myDataStructure);
            myDataStructure.remove(myDataStructure.size() - 1);
        }
    }
}
