package com.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumCandiesAllocatedToKChildren {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n =
        int[] candies = {5, 8, 6};
//        int[] candies = {2,5};
//        long k = 11;
        long k = 3;
        int ans = maximumCandies(candies, k);
        System.out.println(ans);
    }
    private static int maximumCandies(int[] candies, long k) {
        int maximum = 0;
        for (int candy : candies) {
            maximum = Math.max(maximum, candy);
        }
        int low = 1;
        int high = maximum;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (canAllocatedCandies(candies, k, middle)) {
                low = middle + 1;
            }
            else {
                high = middle;
            }
        }
        return canAllocatedCandies(candies, k, low) ? low : low - 1;
    }
    private static boolean canAllocatedCandies(int[] candies, long k, int pileSizeIs) {
        if (pileSizeIs == 0) {
            return true;
        }
        long totalPilesAre = 0;
        for (int candy : candies) {
            totalPilesAre += candy / pileSizeIs;
            if (totalPilesAre >= k) {
                return true;
            }
        }
        return false;
    }
}
