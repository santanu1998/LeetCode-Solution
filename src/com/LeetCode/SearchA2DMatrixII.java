package com.LeetCode;

public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
    }
    private static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < matrix.length && right >= 0) {
            if (matrix[left][right] == target) {
                return true;
            }
            if (matrix[left][right] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }
}
