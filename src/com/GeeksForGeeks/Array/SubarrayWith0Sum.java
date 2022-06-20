package com.GeeksForGeeks.Array;

import java.util.HashSet;
import java.util.Scanner;

public class SubarrayWith0Sum {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }*/
        int[] arr = {4, 2, 0, 1, 6};
        int n = args.length;;
        System.out.println(findSum(arr, n) ? "Yes" : "No");
    }
    private static boolean findSum(int[] arr, int n) {
        HashSet<Integer> hs = new HashSet<>();
        int sum = 0;
        for(int i = 0;i<n;i++) {
            hs.add(sum);
            sum = sum + arr[i];
            if(hs.contains(sum)) {
                return true;
            }
        }
        return false;
    }
}
