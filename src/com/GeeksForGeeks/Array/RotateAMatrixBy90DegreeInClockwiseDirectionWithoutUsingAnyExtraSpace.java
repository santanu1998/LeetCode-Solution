package com.GeeksForGeeks.Array;


public class RotateAMatrixBy90DegreeInClockwiseDirectionWithoutUsingAnyExtraSpace {
    public static int N = 4;
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate90Clockwise(matrix);
        printMatrix(matrix);
    }

    // 1. Naive Approach

    /*private static void rotate90Clockwise(int[][] a) {
        // Traverse each cycle
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    // Function for print matrix
    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }*/

    // 2. Second Approach

    /*private static void rotate90Clockwise(int[][] arr) {
        // printing the matrix on the basis of
        // observations made on indices.
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }*/

    // 3. Third Approach

    /*private static void rotate90Clockwise(int[][] arr) {
        int n=arr.length;
        // first rotation
        // with respect to main diagonal
        for(int i=0;i<n;++i) {
            for(int j=0;j<i;++j) {
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        // Second rotation
        // with respect to middle column
        for(int i=0;i<n;++i) {
            for(int j=0;j<n/2;++j) {
                int temp =arr[i][j];
                arr[i][j] = arr[i][n-j-1];
                arr[i][n-j-1]=temp;
            }
        }
    }*/

    // 4. Fourth Approach

    /*private static void rotate90Clockwise(int[][] arr) {
        int n = arr.length;
        // first rotation
        // with respect to Secondary diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - j][n - 1 - i];
                arr[n - 1 - j][n - 1 - i] = temp;
            }
        }
        // Second rotation
        // with respect to middle row
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - i][j];
                arr[n - 1 - i][j] = temp;
            }
        }
    }*/

    // 5. Fifth Approach

    private static void rotate90Clockwise(int[][] mat) {
        // Transpose of matrix
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
        // Reverse individual rows
        for (int i = 0; i < N; i++) {
            int low = 0, high = N - 1;
            while (low < high) {
                int t = mat[i][low];
                mat[i][low] = mat[i][high];
                mat[i][high] = t;
                low++;
                high--;
            }
        }
    }

    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
