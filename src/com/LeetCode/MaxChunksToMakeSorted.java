package com.LeetCode;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 2, 1, 0};
        int[] arr = {1, 0, 2, 3, 4};
        int answer = maxChunksToSorted(arr);
        System.out.println(answer);
    }
    private static int maxChunksToSorted(int[] arr) {
        int maximum = 0;
        int chunkCount = 0;
        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(arr[i], maximum);
            if (i == maximum) {
                chunkCount++;
            }
        }
        return chunkCount;
    }
}
