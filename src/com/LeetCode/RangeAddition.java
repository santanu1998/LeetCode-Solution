package com.LeetCode;

import java.util.Arrays;

public class RangeAddition {
    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] answer = getModifiedArray(length, updates);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] getModifiedArray(int length, int[][] updates) {
        int[] answer = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int increment = update[2];
            answer[start] += increment;
            if (end + 1 < length) {
                answer[end + 1] += -increment;
            }
        }
        int totalSum = 0;
        for (int i = 0; i < length; i++) {
            totalSum += answer[i];
            answer[i] = totalSum;
        }
        return answer;
    }
}
