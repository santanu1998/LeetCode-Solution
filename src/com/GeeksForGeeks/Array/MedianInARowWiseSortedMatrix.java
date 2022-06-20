package com.GeeksForGeeks.Array;

public class MedianInARowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        int row = matrix.length;
        int column = matrix[0].length;
        int answer = median(matrix, row, column);
        System.out.println(answer);
    }
    private static int median(int[][] matrix, int r, int c) {
        int startValue = 0;
        int endValue = 2000;
        int midValue;
        int totalNumber = r * c;
        while (startValue <= endValue) {
            midValue = (endValue + startValue) / 2;
            int answer = 0;
            for (int i = 0; i < r; i++) {
                int low = 0;
                int high = c - 1;
                while (low <= high) {
                    int middle = low + (high - low) / 2;
                    if (matrix[i][middle] <= midValue) {
                        low = middle + 1;
                    }
                    else {
                        high = middle - 1;
                    }
                }
                answer += low;
            }
            if (answer <= totalNumber / 2) {
                startValue = midValue + 1;
            }
            else {
                endValue = midValue - 1;
            }
        }
        return startValue;
    }
}
