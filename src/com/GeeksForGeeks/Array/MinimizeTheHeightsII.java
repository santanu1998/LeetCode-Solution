package com.GeeksForGeeks.Array;

import java.util.Arrays;

public class MinimizeTheHeightsII {
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
        if (arr.length == 1) {
            return 0;
        }
        Arrays.sort(arr);
        int diff = arr[arr.length - 1] - arr[0];
        int max, min;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] - k < 0) {
                continue;
            }
            max = Math.max(arr[i-1] + k, arr[arr.length - 1] - k);
            min = Math.min(arr[0] + k, arr[i] - k);
            diff = Math.min(diff, max - min);
        }
        return diff;
    }
    private static int getMaxDiff(int[] arr, int k) {
        if (arr.length == 1) {
            return 0;
        }
        Arrays.sort(arr);
        int diff = arr[arr.length - 1] - arr[0];
        int max, min;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] - k < 0) {
                continue;
            }
            max = Math.max(arr[i-1] + k, arr[arr.length - 1] - k);
            min = Math.min(arr[0] + k, arr[i] - k);
            diff = Math.max(diff, max - min);
        }
        return diff;
    }
}
