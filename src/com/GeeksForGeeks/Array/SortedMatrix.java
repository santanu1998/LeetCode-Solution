package com.GeeksForGeeks.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{10,20,30,40}, {15,25,35,45}, {27,29,37,48}, {32,33,39,50}};
        int row = matrix.length;
//        int column = matrix[0].length;
        int[][] answerArray = sortedMatrix(row, matrix);
        printArray(answerArray);
    }
    private static int[][] sortedMatrix(int N, int[][] Mat) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arrayList.add(Mat[i][j]);
            }
        }
        Collections.sort(arrayList);
        int k = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Mat[i][j] = arrayList.get(k++);
            }
        }
        return Mat;
    }
    private static void printArray(int[][] matrix) {
        for (int[] arr : matrix) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();
    }
}
