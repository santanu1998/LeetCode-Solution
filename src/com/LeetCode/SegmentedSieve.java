package com.LeetCode;

import java.util.ArrayList;

public class SegmentedSieve {
    public static void main(String[] args) {
        int a = 2;
        int b = 100;
        ArrayList<Integer> answer = segmentedSieveAlgo(a, b);
        System.out.println(answer);
    }

    public static ArrayList<Integer> segmentedSieveAlgo(int a, int b) {
        int rootOfB = (int) Math.sqrt(b);
        ArrayList<Integer> primes = sieve(rootOfB);
        ArrayList<Integer> answerArrayList = new ArrayList<>();
        boolean[] isPrimeArray = new boolean[b - a + 1];
        for (int prime : primes) {
            int multiple = (int) Math.ceil((a * 1.0) / prime);
            if (multiple == 1) {
                multiple++;
            }
            int startingIndex = multiple * prime - a;
            for (int j = startingIndex; j < isPrimeArray.length; j += prime) {
                isPrimeArray[j] = true;
            }
        }
        for (int i = 0; i < isPrimeArray.length; i++) {
            if (!isPrimeArray[i] && i + a > 1) {
                answerArrayList.add(i + a);
            }
        }
        return answerArrayList;
    }

    private static ArrayList<Integer> sieve(int number) {
        boolean[] isPrimeArray = new boolean[number + 1];
        for (int i = 2; i * i <= isPrimeArray.length; i++) {
            if (!isPrimeArray[i]) {
                for (int j = 2 * i; j < isPrimeArray.length; j += i) {
                    isPrimeArray[j] = true;
                }
            }
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 2; i < isPrimeArray.length; i++) {
            if (!isPrimeArray[i]) {
                answerList.add(i);
            }
        }
        return answerList;
    }
}
