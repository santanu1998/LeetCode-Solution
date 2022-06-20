package com.LeetCode;

public class RangeAdditionII {
    public static void main(String[] args) {
        int row = 3;
        int column = 3;
        int[][] operations = {{2, 2}, {3, 3}};
        int result = maxCount(row, column, operations);
        System.out.println(result);
    }

    private static int maxCount(int m, int n, int[][] ops) {
        int minimumRow = m;
        int minimumColumn = n;
        for (int[] operation : ops) {
            minimumRow = Math.min(minimumRow, operation[0]);
            minimumColumn = Math.min(minimumColumn, operation[1]);
        }
        return (minimumRow * minimumColumn);
    }
}
