package com.LeetCode;

import java.util.Arrays;

public class TransposeOfMatrixWithDimension {
    public static void main(String[] args) {
        int[][] matrix = {{11, 12, 13, 14}, {21, 22, 23, 24}, {31, 32, 33, 34}, {41, 42, 43, 44}};
        transpose(matrix);
        printArray(matrix);
    }
    private static void transpose(int[][] matrix) {
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temporary = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temporary;
            }
        }
    }
    private static void printArray(int[][] matrix) {
        for (int[] matrices : matrix) {
            System.out.println(Arrays.toString(matrices));
        }
    }
}
