package com.LeetCode;

import java.util.*;

public class LongestCommonSubsequenceBetweenSortedArrays {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] arrays = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }*/
        int[][] arrays = {{1, 3, 4}, {1, 4, 7, 9}};
        List<Integer> ans = longestCommomSubsequence(arrays);
        System.out.println(ans);
    }
    private static List<Integer> longestCommomSubsequence(int[][] arrays) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = arrays.length;
        int shortestIndex = 0, shortestLength = arrays[0].length;
        for (int i = 0; i < count; i++) {
            int[] array = arrays[i];
            if (array.length < shortestLength) {
                shortestIndex = i;
                shortestLength = array.length;
            }
            for (int num : array)
                map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> subsequence = new ArrayList<>();
        int[] shortestArray = arrays[shortestIndex];
        for (int i = 0; i < shortestLength; i++) {
            int num = shortestArray[i];
            if (map.get(num) == count)
                subsequence.add(num);
        }
        return subsequence;
    }
}
