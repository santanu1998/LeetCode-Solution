package com.LeetCode;

public class NextGreaterElementIII {
    public static void main(String[] args) {
        int number = 21;
        int answer = nextGreaterElement(number);
        System.out.println(answer);
    }
    private static int nextGreaterElement(int n) {
        long m = n;
        int[] countDigits = new int[10];
        int currentRemainder = -1;
        int previousRemainder = -1;
        while (m > 0) {
            currentRemainder = (int) m % 10;
            m = m / 10;
            countDigits[currentRemainder]++;
            if (previousRemainder > currentRemainder) {
                int number = currentRemainder + 1;
                while (countDigits[number] == 0) {
                    number++;
                }
                countDigits[number]--;
                m = m * 10 + number;
                for (int i = 0; i < 10; i++) {
                    while (countDigits[i]-- > 0) {
                        m = m * 10 + i;
                    }
                }
                return m > Integer.MAX_VALUE ? -1 : (int) m;
            }
            previousRemainder = currentRemainder;
        }
        return -1;
    }
}
