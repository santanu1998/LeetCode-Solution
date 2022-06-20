package com.GeeksForGeeks.Array;

import java.util.Scanner;

public class FindLargestSumContigiousSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        long result = findLargestSum(arr);
        System.out.println(result);
    }

    // 1. First Approach
    /*
    private static long findLargestSum(int[] arr) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int element : arr) {
            sum += element;
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
        // Time Complexity of this is : O(n)
    }
    */
    // 2. Another Approach
    /*
    private static long findLargestSum(int[] arr) {
        long max = arr[0];
        long sum = 0;
        for (int element : arr) {
            sum += element;
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
        // Time Complexity of this is : O(n)
    }
    */
    // 3. Using Math.max() method
    private static long findLargestSum(int[] arr) {
        long max = arr[0];
        long sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }
        return max;
        // Time Complexity of this is : O(n)
    }
}
