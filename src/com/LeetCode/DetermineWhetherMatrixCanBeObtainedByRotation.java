package com.LeetCode;

import java.util.Scanner;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] mat = new int[rows][columns];
        int[][] target = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                target[i][j] = scanner.nextInt();
            }
        }
        */
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        boolean ans = findRotation(mat, target);
        System.out.println(ans);
    }
    private static boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0 ; i < 4; i++) {
            if (sameCheck(mat, target)) {
                return true;
            }
            mat = rotateImage(mat);
        }
        return false;
    }

    private static boolean sameCheck(int[][] mat, int[][] target) {
        if (mat.length == target.length && mat[0].length == target[0].length) {
            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] != target[i][j])
                        return false;
                }
            }
        }
        return true;
    }

    private static int[][] rotateImage(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int[][] newMatrix = new int[columns][rows];
        for(int i = 0 ; i < rows; i++) {
            for(int j = 0 ; j < columns; j++) {
                newMatrix[j][rows - i - 1] = mat[i][j];
            }
        }
        return newMatrix;
    }
}
