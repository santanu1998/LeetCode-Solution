package com.GeeksForGeeks.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        Long[] array = new Long[]{3L, 4L, 1L, 9L, 56L, 7L, 9L, 12L};
        ArrayList<Long> longArrayList = new ArrayList<>();
        Collections.addAll(longArrayList,array);
        long n = longArrayList.size();
        long m = 5;
        long answer = findMinDiff(longArrayList, n, m);
        System.out.println(answer);
    }

    private static long findMinDiff (ArrayList<Long> a, long n, long m) {
        /*long minimizedDifference = Long.MAX_VALUE;              // setting it to be the largest value

        long maxMinDiff = 0;  // max element in window - min element in window
        int M = (int) m;            // since index takes has to be in int
        Collections.sort(a);       // arraylist is a class of collections framework so use collections



        // traversal
        for (int i = 0; i < a.size(); i++) {



            if (i >= M - 1) {          // when window size becomes M or greater
                long maxElementInWindow = a.get(i);
                long minElementInWindow = a.get(i - (M - 1));
                maxMinDiff = maxElementInWindow - minElementInWindow;
                minimizedDifference = Math.min(maxMinDiff, minimizedDifference);
            }

        }
        return minimizedDifference;*/

        Collections.sort(a);
        long minimumDifference = Long.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            minimumDifference = Math.min((a.get(i + (int) m - 1) - a.get(i)), minimumDifference);
        }
        return minimumDifference;
    }
}
