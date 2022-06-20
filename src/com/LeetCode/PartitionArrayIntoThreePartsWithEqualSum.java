package com.LeetCode;

import java.util.Scanner;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        */
        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        boolean ans = canThreePartsEqualSum(arr);
        System.out.println(ans);
    }
    private static boolean canThreePartsEqualSum(int[] arr) {
        int i;
        int sum = 0;
        int n = arr.length;
        for (int ar : arr) {
            sum += ar;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int x = sum / 3;
        int count = 0;
        int curSum = 0;
        for (i = 0; i < n; i++) {
            curSum += arr[i];
            if (curSum == x) {
                count++;
                curSum = 0;
            }
        }
        return count >= 3;
    }
}
