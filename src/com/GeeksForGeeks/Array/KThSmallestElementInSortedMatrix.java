package com.GeeksForGeeks.Array;

public class KThSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{16, 28, 60, 64}, {22, 41, 63, 91}, {27, 50, 87, 93}, {36, 78, 87, 94 }};
        int k = 3;
        int answer = kThSmallest(matrix, k);
        System.out.println(answer);
    }
    private static int kThSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;

        int startValue = matrix[0][0];
        int endValue = matrix[row - 1][column - 1];
        int middleValue;

        while (startValue <= endValue) {

            middleValue = (startValue + endValue) / 2;
            int answer = 0;

            for (int i = 0 ; i < row; i++) {

                int low = 0;
                int middle;
                int high = column - 1;

                while (low <= high) {
                    middle = low + (high - low) / 2;
                    if (matrix[i][middle] <= middleValue) {
                        low = middle + 1;
                    }
                    else {
                        high = middle - 1;
                    }
                }
                answer += low;
            }
            if (answer < k) {
                startValue = middleValue + 1;
            }
            else {
                endValue = middleValue - 1;
            }
        }
        return startValue;
    }
}
