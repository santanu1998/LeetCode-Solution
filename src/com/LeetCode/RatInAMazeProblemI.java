package com.LeetCode;

import java.util.ArrayList;

public class RatInAMazeProblemI {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        int n = m.length;
        ArrayList<String> answer = findPath(m, n);
        System.out.println(answer);
    }

    // Time Complexity of this solution is : O(4^n*m)
    // Auxiliary Space Complexity of this solution is : O(m*n)

    /*
    private static void solveFunction(int i, int j, int[][] a, int n, ArrayList<String> answer, String move, int[][] visited) {
        if (i == n - 1 && j == n - 1) {
            answer.add(move);
            return;
        }

        // downward
        if (i + 1 < n && visited[i + 1][j] == 0 && a[i + 1][j] == 1) {
            visited[i][j] = 1;
            solveFunction(i + 1, j, a, n, answer, move + 'D', visited);
            visited[i][j] = 0;
        }

        // left
        if (j - 1 >= 0 && visited[i][j - 1] == 0 && a[i][j - 1] == 1) {
            visited[i][j] = 1;
            solveFunction(i, j - 1, a, n, answer, move + 'L', visited);
            visited[i][j] = 0;
        }

        // right
        if (j + 1 < n && visited[i][j + 1] == 0 && a[i][j + 1] == 1) {
            visited[i][j] = 1;
            solveFunction(i, j + 1, a, n, answer, move + 'R', visited);
            visited[i][j] = 0;
        }

        // upward
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && a[i - 1][j] == 1) {
            visited[i][j] = 1;
            solveFunction(i - 1, j, a, n, answer, move + 'U', visited);
            visited[i][j] = 0;
        }
    }
    private static ArrayList < String > findPath(int[][] m, int n) {
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }

        ArrayList<String> answer = new ArrayList<>();
        if (m[0][0] == 1) {
            solveFunction(0, 0, m, n, answer, "", visited);
        }
        return answer;
    }
    */

    private static void solveFunction(int i, int j, int[][] a, int n, ArrayList<String> answer, String move, int[][] visited, int[] di, int[] dj) {
        if (i == n - 1 && j == n - 1) {
            answer.add(move);
            return;
        }

        String directory = "DLRU";
        for (int index = 0; index < 4; index++) {
            int nextI = i + di[index];
            int nextJ = j + dj[index];
            if (nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < n && visited[nextI][nextJ] == 0 && a[nextI][nextJ] == 1) {
                visited[i][j] = 1;
                solveFunction(nextI, nextJ, a, n , answer, move + directory.charAt(index), visited, di, dj);
                visited[i][j] = 0;
            }
        }
    }
    private static ArrayList < String > findPath(int[][] m, int n) {
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }
        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        ArrayList<String> answer = new ArrayList<>();
        if (m[0][0] == 1) {
            solveFunction(0, 0, m, n, answer, "", visited, di, dj);
        }
        return answer;
    }
}
