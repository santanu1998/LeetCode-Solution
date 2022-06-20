package com.LeetCode;

import java.util.Scanner;

public class CountingWordsWithAGivenPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            ans += (word.startsWith(pref)) ? 1 : 0;
        }
        return ans;
    }
}
