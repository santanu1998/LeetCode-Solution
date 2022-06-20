package com.GeeksForGeeks.Array;

import java.util.ArrayList;

public class FindPrimeNumbersInARange {
    public static void main(String[] args) {
        int M = 1;
        int N = 10;
        ArrayList<Integer> answer = primeRange(M, N);
        System.out.println(answer);
    }
    private static ArrayList<Integer> primeRange(int M, int N) {
        int rootOfB = (int) Math.sqrt(N);
        ArrayList<Integer> primes = sieve(rootOfB);
        ArrayList<Integer> answerArrayList = new ArrayList<>();
        boolean[] isPrimeArray = new boolean[N - M + 1];
        for (int prime : primes) {
            int multiple = (int) Math.ceil((M * 1.0) / prime);
            if (multiple == 1) {
                multiple++;
            }
            int startingIndex = multiple * prime - M;
            for (int j = startingIndex; j < isPrimeArray.length; j += prime) {
                isPrimeArray[j] = true;
            }
        }
        for (int i = 0; i < isPrimeArray.length; i++) {
            if (!isPrimeArray[i] && i + M > 1) {
                answerArrayList.add(i + M);
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
