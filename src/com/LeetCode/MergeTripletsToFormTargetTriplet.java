package com.LeetCode;

import java.util.Arrays;

public class MergeTripletsToFormTargetTriplet {
    public static void main(String[] args) {
        int[][] triplets = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target = {2, 7, 5};
        boolean answer = mergeTriplets(triplets, target);
        System.out.println(answer);
    }

    // 1. First Approach

     private static boolean mergeTriplets(int[][] triplets, int[] target) {
         int[] mergedArray = new int[3];
         for (int[] triplet : triplets) {
             if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                 mergedArray[0] = Math.max(mergedArray[0], triplet[0]);
                 mergedArray[1] = Math.max(mergedArray[1], triplet[1]);
                 mergedArray[2] = Math.max(mergedArray[2], triplet[2]);
             }
         }
         return Arrays.equals(mergedArray, target);
     }

    // 2. Second Approach

    /*private static boolean mergeTriplets(int[][] triplets, int[] target) {
        return checkingFunction(triplets, target, 0) && checkingFunction(triplets, target, 1) && checkingFunction(triplets, target, 2);
    }

    private static boolean checkingFunction(int[][] triplets, int[] target, int index){
        for (int[] triplet : triplets){
            if (triplet[index] == target[index] && triplet[(index + 1) % 3] <= target[(index + 1) % 3] && triplet[(index + 2) % 3] <= target[(index + 2) % 3])
                return true;
        }
        return false;
    }*/
}
