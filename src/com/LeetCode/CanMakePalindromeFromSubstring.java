package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromeFromSubstring {
    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> ans = canMakePaliQueries(s, queries);
        System.out.println(ans);
    }
    private static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int[] dp = new int[s.length() + 1];

        for (int i = 1; i <= s.length(); ++i)
            dp[i] = dp[i - 1] ^ 1 << s.charAt(i - 1) - 'a';

        for (int[] q : queries) {
            int odds = Integer.bitCount(dp[q[1] + 1] ^ dp[q[0]]);
            ans.add(odds / 2 <= q[2]);
        }

        return ans;
    }
}
