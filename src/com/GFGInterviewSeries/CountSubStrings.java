package com.GFGInterviewSeries;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubStrings {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String S = scanner.next();*/
        String S = "gEEk";
        int ans = countSubstring(S);
        System.out.println(ans);
    }

    private static int countSubstring(String S) {
        HashMap<Integer, Integer> previousSum = new HashMap<>();
        int result = 0;
        int currentSum = 0;

        for(int i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') {
                currentSum++;
            }
            else {
                currentSum--;
            }
            if (currentSum == 0) {
                result++;
            }
            if (previousSum.containsKey(currentSum)) {
                result += previousSum.get(currentSum);
            }
            previousSum.put(currentSum,previousSum.getOrDefault(currentSum, 0) + 1);
        }
        return result;
    }
}
