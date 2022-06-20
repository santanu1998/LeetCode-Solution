package com.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }
        */
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        int[] result = intersection(arr1, arr2);
        for(int element : result) {
            System.out.print("[" + element + "]");
        }
        System.out.println();
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        for (int value : nums1) {
            hs1.add(value);
        }
        for (int element : nums2) {
            if (hs1.contains(element)) {
                hs2.add(element);
            }
        }
        int[] ans = new int[nums1.length];
        int j = 0;
        for(int k : hs2) {
            ans[j++] = k;
        }
        return Arrays.copyOf(ans, j);
    }
}
