package com.LeetCode;

import java.util.Scanner;

public class MinimumNumberOfOperationsToConvertTime {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String current = scanner.next();
//        String correct = scanner.nextLine();
        String current = "02:30";
        String correct = "04:35";
        int ans = convertTime(current, correct);
        System.out.println(ans);
    }
    private static int convertTime(String current, String correct) {
        int currentMinutes = getMinutes(current);
        int correctMinutes = getMinutes(correct);
        int difference = correctMinutes - currentMinutes;
        int ans = 0;
        if (difference > 0) {
            int[] denomination = new int[]{60, 15, 5, 1};
            for (int denominations : denomination) {
                if (difference % denominations == 0) {
                    ans += difference / denominations;
                    break;
                }
                else {
                    ans += difference / denominations;
                    difference = difference % denominations;
                }
            }
        }
        return ans;
    }
    private static int getMinutes(String time) {
        String[] timeStamp = time.split(":");
        int hours = Integer.parseInt(timeStamp[0]);
        int minutes = Integer.parseInt(timeStamp[1]);
        return hours * 60 + minutes;
    }
}
