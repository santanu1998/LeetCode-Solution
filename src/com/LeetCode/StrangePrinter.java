package com.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class StrangePrinter {
    private static int[][] dp;
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        */
        String s = "aaabbb";
//        String s = "aba";
        int result = strangePrinter(s);
        System.out.println(result);
    }

    // TopDown Approach
    // Time Complexity of this solution is : O(n^3)
    // Auxiliary Space complexity of this solution is : O(n^2)
    private static int strangePrinter(String s) {
        int length = s.length();
        dp = new int[length][length];
        return strange(s, 0, length - 1);
    }

    private static int strange(String s, int first, int second) {
        if (first > second) {
            return 0;
        }
        if (dp[first][second] > 0) {
            return dp[first][second];
        }
        dp[first][second] = strange(s, first + 1, second) + 1;
        for (int a = first + 1; a <= second; ++a) {
            if (s.charAt(a) == s.charAt(first)) {
                dp[first][second] = Math.min(dp[first][second], strange(s, first, a - 1) + strange(s, a + 1, second));
            }
        }
        return dp[first][second];
    }

    // BottomUp Approach
    // Time Complexity of this solution is : O(n^3)
    // Auxiliary Space complexity of this solution is : O(n^2)

    /*
    private static int strangePrinter(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        // dp[i][j] := min # of turns to print s[i..j]
        int[][] dp = new int[length][length];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, length));
        for (int i = 0; i < length; ++i) {
            dp[i][i] = 1;
        }
        for (int j = 0; j < length; ++j) {
            for (int i = j; i >= 0; --i) {
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] - (s.charAt(k) == s.charAt(j) ? 1 : 0));
                }
            }
        }
        return dp[0][length - 1];
    }
    */
}
