package com.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeadersInAnArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        List<Integer> ans = leaders(arr, n);
        System.out.println(ans);
    }
    private static ArrayList<Integer> leaders(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[n - 1]);
        int maximum = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maximum) {
                ans.add(arr[i]);
                maximum = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
