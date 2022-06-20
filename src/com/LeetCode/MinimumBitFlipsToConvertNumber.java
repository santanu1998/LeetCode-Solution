package com.LeetCode;

import java.util.Scanner;

public class MinimumBitFlipsToConvertNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int goal = scanner.nextInt();
        int ans = minBitFlips(start, goal);
        System.out.println(ans);
    }
    private static int minBitFlips(int start, int goal) {
        return countSetBitsGoal(start ^ goal);
    }
    private static int countSetBitsGoal(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n-1);
        }
        return count;
    }
}
