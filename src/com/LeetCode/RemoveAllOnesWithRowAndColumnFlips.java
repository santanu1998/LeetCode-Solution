package com.LeetCode;
import java.util.*;
public class RemoveAllOnesWithRowAndColumnFlips {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        */
        int[][] grid = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 0, 1}};
        boolean ans = removeOnes(grid);
        System.out.println(ans);
    }
    private static boolean removeOnes(int[][] grid) {
        int[] revRow = getRevRow(grid[0]);
        return Arrays.stream(grid).allMatch(
                row -> Arrays.equals(row, grid[0]) || Arrays.equals(row, revRow));
    }

    private static int[] getRevRow(int[] row) {
        int[] revRow = new int[row.length];
        for (int i = 0; i < row.length; ++i)
            revRow[i] = row[i] ^ 1;
        return revRow;
    }
}
