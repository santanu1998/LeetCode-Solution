package com.LeetCode;

import java.util.Scanner;

public class JumpGameII {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        */
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
//        int[] arr = {1, 4, 3, 2, 6, 7};
        int ans = minJumps(arr);
        System.out.println(ans);
    }

    // First Approach
    /*
    private static int minJumps(int[] arr) {
        int idx = 0, target = 0, ans = 0, temp = 0, n = arr.length;
        if (n == 1) {
//            if (arr[0] == 0) {
//                return 0;
//            }
            return 0;
        }
        while (idx < n && target < n - 1) {
            while (idx <= target) {
                temp = Math.max(temp, arr[idx] + idx);
                ++idx;
            }
            if (temp <= target) {
                return -1;
            }
            target = temp;
            ++ans;
        }
        return ans;
        // Time Complexity is : O(n)
        // Auxiliary Space Complexity is : O(1)
    }
    */
    // Second Approach
    private static int minJumps(int[] arr) {
        int sum = 0, i = 0, c = 1, n = arr.length;
        if (n == 1) {
//            if (arr[0] == 0) {
//                return 0;
//            }
            return 0;
        }
        int steps = arr[0];
        int curr = arr[0];
        while (i <= Math.min(curr, n - 1)) {
            if (steps < i) {
                c++;
                steps = curr;
            }
            curr = Math.max(curr, i + arr[i]);
            i++;
        }
        if (curr >= n - 1) {
            return c;
        }
        return -1;
        // Time Complexity is : O(n)
        // Auxiliary Space Complexity is : O(1)
    }
}

