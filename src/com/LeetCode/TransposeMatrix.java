package com.LeetCode;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] answer = transpose(matrix);
        for (int[] ans : answer) {
            System.out.println(Arrays.toString(ans));
        }
    }
    private static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] answerArray = new int[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                answerArray[i][j] = matrix[j][i];
            }
        }
        return answerArray;
    }
}
