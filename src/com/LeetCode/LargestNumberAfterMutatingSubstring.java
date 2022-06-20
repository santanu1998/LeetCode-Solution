package com.LeetCode;

import java.util.Scanner;

public class LargestNumberAfterMutatingSubstring {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int n = scanner.nextInt();
        int[] change = new int[n];
        for (int i = 0; i < n; i++) {
            change[i] = scanner.nextInt();
        }
        */
        String num = "132";
        int[] change = {9, 8, 5, 0, 3, 6, 4, 2, 6, 8};
        String ans = maximumNumber(num, change);
        System.out.println(ans);
    }
    private static String maximumNumber(String num, int[] change) {
        StringBuilder max = new StringBuilder();
        int i = 0;
        while (i < num.length() && change[num.charAt(i)-'0'] <= (num.charAt(i)-'0')) {
            max.append(num.charAt(i));
            i++;
        }
        while (i < num.length() && change[num.charAt(i)-'0'] >= (num.charAt(i)-'0')) {
            max.append(change[num.charAt(i)-'0']);
            i++;
        }
        return max.toString() + num.substring(i, num.length());
    }
}
