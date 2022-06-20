package com.GeeksForGeeks.Array;

import java.util.HashMap;
import java.util.Map;

public class CommonElementsInAllRowsOfAGivenMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 1, 4, 8}, {3, 7, 8, 5, 1}, {8, 7, 7, 3, 1}, {8, 1, 2, 7, 9}};
        printCommonElements(matrix);
    }

    private static void printCommonElements(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        Map<Integer,Integer> mp = new HashMap<>();
        // initialize 1st row elements with value 1
        for (int j = 0; j < column; j++) {
            mp.put(matrix[0][j], 1);
        }
        // traverse the matrix
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // If element is present in the map and
                // is not duplicated in current row.
                if (mp.get(matrix[i][j]) != null && mp.get(matrix[i][j]) == i) {
                    // we increment count of the element
                    // in map by 1
                    mp.put(matrix[i][j], i + 1);
                    // If this is last row
                    if (i == row - 1) {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }
        }
    }
}
