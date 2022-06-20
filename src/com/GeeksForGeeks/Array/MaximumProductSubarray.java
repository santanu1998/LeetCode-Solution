package com.GeeksForGeeks.Array;

import java.util.Scanner;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }*/
        int[] arr = {6, -3, -10, 0, 2};
        int n = arr.length;
        long answer = maxProduct(arr, n);
        System.out.println(answer);
    }
    private static long maxProduct(int[] arr, int n) {
        long product = arr[0];
        long maximum = arr[0];
        long minimum = arr[0];

        for(int i = 1; i < n; i++) {
            long first = maximum * arr[i];
            long second = minimum * arr[i];

            maximum = Math.max(arr[i],Math.max(first, second));
            minimum = Math.min(arr[i], Math.min(first, second));
            product = Math.max(product, maximum);
        }
        return product;
    }
}
