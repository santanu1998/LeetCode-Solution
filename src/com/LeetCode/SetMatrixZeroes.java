package com.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        */
        int[][] matrix = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 0, 1}};
        setZeroes(matrix);
        printArray(matrix);
    }

    private static void setZeroes(int[][] matrix) {
        int column0 = 1;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                column0 = 0;
            }
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0 ; i--) {
            for (int j = columns - 1; j >= 0 ; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (column0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
    private static void printArray(int[][] matrix) {
        for (int[] mat : matrix) {
            System.out.print(Arrays.toString(mat) + " ");
        }
        System.out.println();
    }
}
