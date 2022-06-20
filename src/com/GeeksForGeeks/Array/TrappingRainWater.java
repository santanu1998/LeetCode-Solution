package com.GeeksForGeeks.Array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 2, 0, 4};
        int n = arr.length;
        long answer = trappingWater(arr, n);
        System.out.println(answer);
    }

    private static long trappingWater(int[] arr, int n) {
        long answer = 0;
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];
        int firstMaximum = arr[0];
        for(int i = 0; i < n; i++) {
            if(arr[i] > firstMaximum) {
                firstMaximum = arr[i];
            }
            firstArray[i] = firstMaximum;
        }
        int secondMaximum = arr[n - 1];
        for(int j = n - 1; j >= 0; j--) {
            if(arr[j] > secondMaximum) {
                secondMaximum = arr[j];
            }
            secondArray[j] = secondMaximum;
        }
        for(int k = 0; k < n; k++) {
            int thirdMaximum = Math.min(firstArray[k], secondArray[k]);
            answer = answer + (thirdMaximum - arr[k]);
        }
        return answer;
    }
}
