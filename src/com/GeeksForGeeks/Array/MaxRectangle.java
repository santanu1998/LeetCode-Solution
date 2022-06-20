package com.GeeksForGeeks.Array;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        int row = matrix.length;
        int column = matrix[0].length;
        int answer = maxArea(matrix, row, column);
        System.out.println(answer);
    }

    private static int maxArea(int[][] M, int m, int n) {
        int result = 0;
        int[] array = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    array[j] = 0;
                }
                else {
                    array[j] = array[j] + M[i][j];
                }
            }
            result = Math.max(result, findMaximum(array, n));
        }
        return result;
    }

    private static int findMaximum(int[] array, int n) {
        int result = 0;
        int height = 0;
        int position = 0;
        int i = 1;
        Stack<Integer> startingPosition = new Stack<>();
        Stack<Integer> heights = new Stack<>();
        for (i = 0; i < n; i++) {
            if (heights.isEmpty() || array[i] >heights.peek()) {
                startingPosition.push(i);
                heights.push(array[i]);
            }
            else if (array[i] < heights.peek()) {
                while (!heights.isEmpty() && array[i] < heights.peek()) {
                    height = heights.pop();
                    position = startingPosition.pop();
                    result = Math.max(result, height * (i - position));
                }
                startingPosition.push(position);
                heights.push(array[i]);
            }
        }
        while (!heights.isEmpty()) {
            height = heights.pop();
            position = startingPosition.pop();
            result = Math.max(result, height * (i - position));
        }
        return result;
    }
}
