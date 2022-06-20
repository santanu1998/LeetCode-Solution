package com.LeetCode;

import java.util.Scanner;

public class SubstringsThatBeginAndEndWithTheSameLetter {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        */
        String s = "abac";
        long ans = numberOfSubstrings(s);
        System.out.println(ans);
    }
    private static long numberOfSubstrings(String s) {
        long result = 0;
        int[] count = new int[128];

        for (char ch : s.toCharArray()) {
            result += count[ch] + 1;
            ++count[ch];
        }
        return result;
    }
}
