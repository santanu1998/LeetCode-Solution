package com.LeetCode;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
    }
    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0;
        int high = (row * column) - 1;
        while (low <= high) {
            int middle = (low + (high - low) / 2);
            if (matrix[middle / column][middle % column] == target) {
                return true;
            }
            if (matrix[middle / column][middle % column] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return false;
    }
}
