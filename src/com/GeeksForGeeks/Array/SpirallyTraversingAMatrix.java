package com.GeeksForGeeks.Array;

import java.util.ArrayList;

public class SpirallyTraversingAMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15,16}};
        int row = matrix.length;
        int column = matrix[0].length;
        ArrayList<Integer> answer = spirallyTraverse(matrix, row, column);
        System.out.println(answer);
    }
    private static ArrayList<Integer> spirallyTraverse(int[][] matrix, int r, int c) {
        ArrayList<Integer> answer = new ArrayList<>();
        int startRow = 0;
        int endRow = r - 1;
        int startColumn = 0;
        int endColumn = c - 1;
        while (startRow <= endRow && startColumn <= endColumn) {
            for (int i = startColumn; i <= endColumn; i++) {
                answer.add(matrix[startRow][i]);
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                answer.add(matrix[i][endColumn]);
            }
            endColumn--;
            if (startRow <= endRow) {
                for (int i = endColumn; i >= startColumn; i--) {
                    answer.add(matrix[endRow][i]);
                }
                endRow--;
            }
            if (startColumn <= endColumn) {
                for (int i = endRow; i >= startRow; i--) {
                    answer.add(matrix[i][startColumn]);
                }
                startColumn++;
            }
        }
        return answer;
    }
}
