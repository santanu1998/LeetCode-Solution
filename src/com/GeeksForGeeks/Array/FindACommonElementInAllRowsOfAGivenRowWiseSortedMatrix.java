package com.GeeksForGeeks.Array;

import java.util.HashMap;
import java.util.Map;

public class FindACommonElementInAllRowsOfAGivenRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}};
        int answer = findCommon(matrix);
        System.out.println(answer);
    }

    // 1. Naive Approach

    /*private static int findCommon(int[][] matrix) {
        // An array to store indexes
        // of current last column
        int row = matrix.length;
        int column = matrix[0].length;
        int[] columnArray = new int[row];
        // To store index of row whose current
        // last element is minimum
        int minimumRow;
        // Initialize current last element of all rows
        int i;
        for (i = 0; i < row; i++) {
            columnArray[i] = column - 1;
        }
        // Initialize min_row as first row
        minimumRow = 0;
        // Keep finding min_row in current last column, till either
        // all elements of last column become same or we hit first column.
        while (columnArray[minimumRow] >= 0) {
            // Find minimum in current last column
            for (i = 0; i < row; i++) {
                if (matrix[i][columnArray[i]] < matrix[minimumRow][columnArray[minimumRow]]) {
                    minimumRow = i;
                }
            }
            // eq_count is count of elements equal to minimum in current last
            // column.
            int eqCount = 0;
            // Traverse current last column elements again to update it
            for (i = 0; i < row; i++) {
                // Decrease last column index of a row whose value is more
                // than minimum.
                if (matrix[i][columnArray[i]] > matrix[minimumRow][columnArray[minimumRow]]) {
                    if (columnArray[i] == 0) {
                        return -1;
                    }
                    // Reduce last column index by 1
                    columnArray[i] -= 1;
                } else {
                    eqCount++;
                }
            }
            // If equal count becomes M,
            // return the value
            if (eqCount == row) {
                return matrix[minimumRow][columnArray[minimumRow]];
            }
        }
        return -1;
    }*/

    // 2. Efficient Approach

    private static int findCommon(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // A hash map to store count of elements
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int i, j;
        for (i = 0; i < row; i++) {
            // Increment the count of first
            // element of the row
            if(countMap.containsKey(matrix[i][0])) {
                countMap.put(matrix[i][0], countMap.get(matrix[i][0]) + 1);
            }
            else {
                countMap.put(matrix[i][0], 1);
            }
            // Starting from the second element
            // of the current row
            for (j = 1; j < column; j++) {
                // If current element is different from
                // the previous element i.e. it is appearing
                // for the first time in the current row
                if (matrix[i][j] != matrix[i][j - 1]) {
                    if (countMap.containsKey(matrix[i][j])) {
                        countMap.put(matrix[i][j], countMap.get(matrix[i][j]) + 1);
                    }
                    else {
                        countMap.put(matrix[i][j], 1);
                    }
                }
            }
        }
        // Find element having count
        // equal to number of rows
        for (Map.Entry<Integer, Integer> ele : countMap.entrySet()) {
            if (ele.getValue() == row) {
                return ele.getKey();
            }
        }
        // No such element found
        return -1;
    }
}
