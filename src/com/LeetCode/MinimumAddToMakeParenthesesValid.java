package com.LeetCode;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String s = "())";
        int answer = minAddToMakeValid(s);
        System.out.println(answer);
    }

    private static int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            }
            else {
                if (open == 0) {
                    close++;
                }
                else {
                    open--;
                }
            }
        }
        return (open + close);
    }
}
