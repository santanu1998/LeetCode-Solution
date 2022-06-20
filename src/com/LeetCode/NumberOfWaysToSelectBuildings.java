package com.LeetCode;

import java.util.Scanner;

public class NumberOfWaysToSelectBuildings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        long ans = numberOfWays(s);
        System.out.println(ans);
    }

    private static long numberOfWays(String s) {
        long ans = 0;
        int length = s.length();

        long totalZeros = 0;

        for(int i = 0; i < length; i++){
            totalZeros += s.charAt(i)=='0' ? 1 : 0;
        }

        long totalOnes = length - totalZeros;

        long currentZeros = s.charAt(0) == '0' ? 1 : 0;
        long currentOnes = s.charAt(0) == '1' ? 1 : 0;

        for(int i = 1; i < length; i++){
            if(s.charAt(i) == '0'){
                ans = ans + (currentOnes * (totalOnes - currentOnes));
                currentZeros++;
            }else{
                ans = ans + (currentZeros * (totalZeros - currentZeros));
                currentOnes++;
            }
        }
        return ans;
    }
}
