package com.LeetCode;

import java.util.HashMap;

public class SubarrayWithGivenXOR {
    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 6, 4};
        int B = 6;
        int ans = solve(nums, B);
        System.out.println(ans);
    }
    private static int solve(int[] A, int B) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int count = 0;
        int xorr = 0;
        int length = A.length;
        for (int j : A) {
            xorr = xorr ^ j;
            if (frequency.get(xorr ^ B) != null) {
                count += frequency.get(xorr ^ B);
            }
            if (xorr == B) {
                count++;
            }
            if (frequency.get(xorr) != null) {
                frequency.put(xorr, frequency.get(xorr) + 1);
            } else {
                frequency.put(xorr, 1);
            }
        }
        return count;
    }
}
