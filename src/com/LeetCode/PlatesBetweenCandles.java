package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlatesBetweenCandles {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String s = scanner.nextLine();
        int[][] queries = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                queries[i][j] = scanner.nextInt();
            }
        }
        */
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        int[] ans = platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(ans));
    }
    private static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        List<Integer> list = new ArrayList<>(); // indices of '|'

        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == '|')
                list.add(i);

        for (int i = 0; i < queries.length; ++i) {
            int left = queries[i][0];
            int right = queries[i][1];
            int lft = firstGreaterEqual(list, left);
            int rht = firstGreaterEqual(list, right + 1) - 1;
            if (lft < rht) {
                int lengthBetweenCandles = list.get(rht) - list.get(lft) + 1;
                int numCandles = rht - lft + 1;
                ans[i] = lengthBetweenCandles - numCandles;
            }
        }

        return ans;
    }

    private static int firstGreaterEqual(List<Integer> list, int target) {
        int lft = 0;
        int rht = list.size();
        while (lft < rht) {
            int a = (lft + rht) / 2;
            if (list.get(a) >= target)
                rht = a;
            else
                lft = a + 1;
        }
        return lft;
    }
}
