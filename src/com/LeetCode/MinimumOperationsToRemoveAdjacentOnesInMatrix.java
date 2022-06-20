package com.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumOperationsToRemoveAdjacentOnesInMatrix {
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
        int ans = minimumOperations(grid);
        System.out.println(ans);
    }

    private static int minimumOperations(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int ans = 0;
        int[][] seen = new int[rows][columns];
        int[][] match = new int[rows][columns];
        Arrays.stream(match).forEach(A -> Arrays.fill(A, -1));

        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < columns; ++j)
                if (grid[i][j] == 1 && match[i][j] == -1) {
                    int sessionId = i * columns + j;
                    seen[i][j] = sessionId;
                    if (dfs(grid, i, j, sessionId, seen, match))
                        ++ans;
                }

        return ans;
    }

    private static final int[] dirs = {0, 1, 0, -1, 0};

    private static boolean dfs(int[][] grid, int i, int j, int sessionId, int[][] seen, int[][] match) {
        int rows = grid.length;
        int columns = grid[0].length;

        for (int k = 0; k < 4; ++k) {
            final int x = i + dirs[k];
            final int y = j + dirs[k + 1];
            if (x < 0 || x == rows || y < 0 || y == columns)
                continue;
            if (grid[x][y] == 0 || seen[x][y] == sessionId)
                continue;
            seen[x][y] = sessionId;
            if (match[x][y] == -1 ||
                    dfs(grid, match[x][y] / columns, match[x][y] % columns, sessionId, seen, match)) {
                match[x][y] = i * columns + j;
                match[i][j] = x * columns + y;
                return true;
            }
        }

        return false;
    }

    // Time Complexity is : O(|V||E|) = O(m^2 * n^2)
    // Auxiliary Space Complexity is : O(mn)
}
