package com.GeeksForGeeks.Array;

public class SmallestSubarrayWithSumGreaterThanX {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        int n = arr.length;
        int x = 51;
        int answer = smallestSubWithSum(arr, n, x);
        System.out.println(answer);
    }
    private static int smallestSubWithSum(int[] a, int n, int x) {
        int low = 0;
        int high = 1;
        int answer = Integer.MAX_VALUE;
        int totalSum = a[low];
        if (totalSum > x) {
            return 1;
        }
        if (high < n) {
            totalSum += a[high];
        }
        while (low < n && high < n) {
            if (totalSum > x) {
                answer = Math.min(answer, high - low + 1);
                totalSum -= a[low];
                low++;
            }
            else {
                high++;
                if (high < n) {
                    totalSum += a[high];
                }
            }
        }
        return answer;
    }
}
