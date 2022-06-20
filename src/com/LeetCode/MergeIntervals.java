package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] intervals = new int[n][];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                intervals[i][j] = scanner.nextInt();
            }
        }
        */
        int[][] intervals = {{1, 3},{2, 6},{8,10},{15, 18}};
        int[][] result = merge(intervals);
        for (int[] res : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(res[j] + " ");
            }
        }
        System.out.println();
    }


    // 1. First Approach
    /*
    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if(list.size() == 0) {
                list.add(interval);
            }
            else  {
                int[] prevInterval = list.get(list.size() - 1);
                if (interval[0] <= prevInterval[1]) {
                    prevInterval[1] = Math.max(prevInterval[1], interval[1]);
                }
                else {
                    list.add(interval);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    */

    // 2. Second Approach
    private static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] interval : intervals) {
            if(interval[0] <= end) {
                end = Math.max(end, interval[1]);
            }
            else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}
