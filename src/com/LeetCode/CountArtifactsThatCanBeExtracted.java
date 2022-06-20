package com.LeetCode;

import java.util.Scanner;

public class CountArtifactsThatCanBeExtracted {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] artifacts = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < artifacts[i].length; j++) {
                artifacts[i][j] = scanner.nextInt();
            }
        }
        int[][] dig = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dig[i].length; j++) {
                dig[i][j] = scanner.nextInt();
            }
        }
        */
        int[][] artifacts = {{0, 0, 0, 0}, {0, 1, 1, 1}};
        int[][] dig = {{0, 0}, {0, 1}, {1, 1}};
        int n = 2;
        int ans = digArtifacts(n, artifacts, dig);
        System.out.println(ans);
    }

    private static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] uncovered = new boolean[n][n];
        for (int[] digged : dig) {
            uncovered[digged[0]][digged[1]] = true;
        }
        int count = 0;
        for (int[] artifact : artifacts) {
            boolean canBeExtracted = true;
            for (int i = artifact[0]; i <= artifact[2]; i++) {
                for (int j = artifact[1]; j <= artifact[3]; j++) {
                    if (!uncovered[i][j]) {
                        canBeExtracted = false;
                        break;
                    }
                }
            }
            if (canBeExtracted) {
                count++;
            }
        }
        return count;
    }
}
