package com.GeeksForGeeks.Array;

import java.util.Arrays;

public class MinimizeTheHeightsI {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        */
//        int[] arr = {1, 5, 8, 10};
        int[] arr = {3, 9, 12, 16, 20};
//        int k = 2;
        int k = 3;
        int result = getMinDiff(arr, k);
        System.out.println(result);
        int ans = getMaxDiff(arr, k);
        System.out.println(ans);
    }

    private static int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int ans = arr[arr.length - 1] - arr[0];
        int smallest = arr[0] + k;
        int largest = arr[arr.length - 1] - k;
        int max, min;
        for (int i = 0; i < arr.length - 1 ; i++) {
            min = Math.min(smallest, arr[i + 1] - k);
            max = Math.max(largest, arr[i] - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
    private static int getMaxDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int ans = arr[arr.length - 1] - arr[0];
        int smallest = arr[0] + k;
        int largest = arr[arr.length - 1] - k;
        int max, min;
        for (int i = 0; i < arr.length - 1 ; i++) {
            min = Math.min(smallest, arr[i + 1] - k);
            max = Math.max(largest, arr[i] - k);
            ans = Math.max(ans, max - min);
        }
        return ans;
    }
}
