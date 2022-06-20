package com.LeetCode;

import java.util.Arrays;

public class ParallelCoursesII {
    public static void main(String[] args) {
        int n = 4;
        int[][] relations = {{2, 1}, {3, 1}, {1, 4}};
        int k = 2;
        int ans = minNumberOfSemesters(n, relations, k);
        System.out.println(ans);
    }

    // Time Complexity is : O(2^n * n)
    // Auxiliary Space Complexity is : O(2^n)

    private static int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] dynamic = new int[1 << n];
        Arrays.fill(dynamic, n);
        // prereq[i] := bit representation of all dependencies of course i
        int[] myArr = new int[n];

        for (int[] relation : relations) {
            int previousCourse = relation[0] - 1;
            int nextCourse = relation[1] - 1;
            myArr[nextCourse] |= 1 << previousCourse;
        }

        dynamic[0] = 0; // no need time to finish 0 course

        for (int i = 0; i < dynamic.length; ++i) {
            // bit representation of all the courses can be taken
            int coursesCanBeTakenBy = 0;
            // can take course j if i contains all j's prerequisites
            for (int j = 0; j < n; ++j) {
                if ((i & myArr[j]) == myArr[j]) {
                    coursesCanBeTakenBy |= 1 << j;
                }
            }
            // don't take any course which is already taken
            // (i represents set of courses that are already taken)
            coursesCanBeTakenBy &= ~i;
            // enumerate all bit subset of coursesCanBeTaken
            for (int a = coursesCanBeTakenBy; a > 0; a = (a - 1) & coursesCanBeTakenBy) {
                if (Integer.bitCount(a) <= k) {
                    // any combination of courses (if <= k) can be taken now
                    // i | s := combining courses taken with courses can be taken
                    dynamic[i | a] = Math.min(dynamic[i | a], dynamic[i] + 1);
                }
            }
        }
        return dynamic[(1 << n) - 1];
    }
}
