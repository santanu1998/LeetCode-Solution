package com.LeetCode;

public class MaxChunksToMakeSortedII {
    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 4, 4};
        int[] arr = {5, 4, 3, 2, 1};
        int answer = maxChunksToSorted(arr);
        System.out.println(answer);
    }

    private static int maxChunksToSorted(int[] arr) {
        int[] rightMinimum = new int[arr.length + 1];
        rightMinimum[arr.length] = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            rightMinimum[i] = Math.min(rightMinimum[i + 1], arr[i]);
        }
        int leftMaximum = Integer.MIN_VALUE;
        int chunkCount = 0;
        for (int i = 0; i < arr.length; i++) {
            leftMaximum = Math.max(leftMaximum, arr[i]);
            if (leftMaximum <= rightMinimum[i + 1]) {
                chunkCount++;
            }
        }
        return chunkCount;
    }
}
