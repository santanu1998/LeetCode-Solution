package com.GeeksForGeeks.Array;

import java.util.ArrayList;

public class ProductOfPrimes {
    public static void main(String[] args) {
        long L = 1;
        long R = 10;
        long result = primeProduct(L, R);
        System.out.println(result);
    }

    /*private static long primeProduct(long L, long R){
        ArrayList<Long> answer = primeRange(L, R);
        long result = 1;
        for (Long aLong : answer) {
            result *= aLong;
        }
        return result;
    }
    private static ArrayList<Long> primeRange(long M, long N) {
        long rootOfB = (long) Math.sqrt(N);
        ArrayList<Long> primes = sieve(rootOfB);
        ArrayList<Long> answerArrayList = new ArrayList<>();
        boolean[] isPrimeArray = new boolean[(int) (N - M + 1)];
        for (long prime : primes) {
            long multiple = (long) Math.ceil((M * 1.0) / prime);
            if (multiple == 1) {
                multiple++;
            }
            long startingIndex = multiple * prime - M;
            for (int j = (int) startingIndex; j < isPrimeArray.length; j += prime) {
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

    private static ArrayList<Long> sieve(long number) {
        boolean[] isPrimeArray = new boolean[(int) (number + 1)];
        for (int i = 2; i * i <= isPrimeArray.length; i++) {
            if (!isPrimeArray[i]) {
                for (int j = 2 * i; j < isPrimeArray.length; j += i) {
                    isPrimeArray[j] = true;
                }
            }
        }
        ArrayList<Long> answerList = new ArrayList<>();
        for (int i = 2; i < isPrimeArray.length; i++) {
            if (!isPrimeArray[i]) {
                answerList.add((long) i);
            }
        }
        return answerList;
    }*/

    private static long primeProduct (long L, long R) {
        long mod = 1000000007;
        int SIZE = (int) (R - L + 1);
        // By default value is false, which means that value is prime
        boolean[] primes = new boolean[SIZE];
        for (long i = 2; i <= R / 2; ++i) {
            long start = L % i == 0 ? L : L + (i - (L % i));
            //We are checking start is equal to i or not because when L is smaller than
            //i, then start will be equal to i as per code above but in this case start or i
            //is a prime, so we cannot mark primes[start] true (if it is false), so we will
            //increment start to its next value
            if (start == i) {
                start = start + i;
            }
            int index = 0;
            while (start <= R) {
                index = (int) (start - L);
                primes[index] = true;
                start += i;
            }
        }
        long product = 1;
        for (int i = 0; i < SIZE; ++i) {
            if (!primes[i]) {
                product = (product * (L + i)) % mod;
            }
        }
        return product;
    }
}
