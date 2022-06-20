package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> answer = partition(s);
        System.out.println(answer);
    }
    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> myPath = new ArrayList<>();
        myFunction(0, s, myPath, result);
        return result;
    }

    private static void myFunction(int index, String s, List<String> myPath, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(myPath));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                myPath.add(s.substring(index, i + 1));
                myFunction(i + 1, s, myPath, result);
                myPath.remove(myPath.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
