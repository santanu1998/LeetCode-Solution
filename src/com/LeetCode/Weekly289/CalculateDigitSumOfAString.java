package com.LeetCode.Weekly289;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateDigitSumOfAString {
    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;
        String ans = digitSum(s, k);
        System.out.println(ans);
    }
    private static String digitSum(String s, int k) {
        while (s.length() > k) {
            char[] myArray = s.toCharArray();
            s = "";
            int first = 0;
            while (first < myArray.length) {
                int k2 = k;
                int sum = 0;
                while (first < myArray.length && k2-- > 0) {
                    sum += (myArray[first] - '0');
                    first++;
                }
                s = s + "" + sum;
            }
        }
        return s;
    }
}
