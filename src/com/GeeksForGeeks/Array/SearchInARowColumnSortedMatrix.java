package com.GeeksForGeeks.Array;

public class SearchInARowColumnSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{ 3, 30, 38}, {36, 43, 60}, {40, 51, 69}};
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 62;
        if (search(matrix, n, m, x)) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
    private static boolean search(int[][] matrix, int n, int m, int x) {
        if (n == 1) {
            int[] matrix1 = matrix[0];
            int start = 0;
            int end = m - 1;
            while (start <= end) {
                int middle = start + (end - start) / 2;
                if (matrix1[middle] == x) {
                    return true;
                }
                else if (matrix1[middle] > x) {
                    end = middle - 1;
                }
                else {
                    start = middle + 1;
                }
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (matrix[i][0] <= x && matrix[i][m - 1] >= x) {
                    int[] matrix1 = matrix[i];
                    int start = 0;
                    int end = m - 1;
                    while (start <= end) {
                        int middle = start + (end - start) / 2;
                        if (matrix1[middle] == x) {
                            return true;
                        }
                        else if (matrix1[middle] > x) {
                            end = middle - 1;
                        }
                        else {
                            start = middle + 1;
                        }
                    }
                }
            }
        }
        return false;
    }
}
