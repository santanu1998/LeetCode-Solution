package com.GeeksForGeeks.String;

import java.util.HashSet;

public class RemoveAndReverse {
    public static void main(String[] args) {
        String S = "abab";
        String ans = removeReverse(S);
        System.out.println(ans);
    }
    private static String removeReverse(String S) {
        return firstRepeating(S);
    }
    private static String firstRepeating(String S) {
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> set1 = new HashSet<>();
        // char[] chArr = S.toCharArray();
        for (int i = 0; i <= S.length() - 1; i++) {
            char ch = S.charAt(i);
            if (set.contains(ch)) {
                // return ch;
                set.remove(ch);
                String a = reverse(S);
                char c = a.charAt(i);
                set.add(c);
                return set.toString();
            }
            else {
                set.add(ch);
            }
        }
        return "";
    }
    private static String reverse(String S) {
        StringBuilder sb = new StringBuilder(S);
        sb.reverse();
        return sb.toString();
    }
}
