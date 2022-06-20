package com.LeetCode;

import java.util.Scanner;

public class SumOfScoresOfBuiltStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        long ans = sumScores(s);
        System.out.println(ans);
    }
//    private static long sumScores(String s) {
//        int[] countArray = countZArray(s);
//        long sum = (long) s.length();
//        for (int i = 1; i < s.length(); i++) {
//            long value = (long) countArray[i];
//            sum += value;
//        }
//        return sum;
//    }
//    private static int[] countZArray(String s) {
//        int length = s.length();
//        int[] countArray = new int[length];
//        for (int i = 1, j = 0, k = 0; i < length; ++i) {
//            if (i <= k) {
//                countArray[i] = Math.min(k - i + 1, countArray[i - j]);
//            }
//            while (i + countArray[i] < length && s.charAt(countArray[i]) == s.charAt(i + countArray[i]))
//                ++countArray[i];
//            if (i + countArray[i] - 1 > k)
//                j = i;
//                k = i + countArray[i] - 1;
//        }
//        return countArray;
//    }
//    private static int[] countZArray(String s) {
//        int length = s.length();
//        int[] countArray = new int[length];
//        for (int i = 1; i < length; ++i) {
//            while (i + countArray[i] < length && s.charAt(countArray[i]) == s.charAt(i + countArray[i])) {
//                ++countArray[i];
//            }
//        }
//        return countArray;
//    }
    private static long sumScores(String s) {
        char[] ch = s.toCharArray();
        int length = ch.length;
        int a = 0;
        int b= 0;
        int[] countArray= new int[length];
        long ans = length;
        for(int i = 1; i < length; i++) {
            countArray[i]= Math.max(0, Math.min(countArray[i - a], b - i + 1));
            while(i + countArray[i] < length && ch[countArray[i]] == ch[i + countArray[i]]){
                a = i;
                b = i + countArray[i];
                countArray[i]++;
            }
            ans += countArray[i];
        }
        return ans;
    }
}
