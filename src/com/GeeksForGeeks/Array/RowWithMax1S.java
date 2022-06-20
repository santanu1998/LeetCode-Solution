package com.GeeksForGeeks.Array;

public class RowWithMax1S {
    public static void main(String[] args) {
        int[][] array = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        int row = array.length;
        int column = array[0].length;
        int answer = rowWithMax1S(array, row, column);
        System.out.println(answer);
    }
    private static int rowWithMax1S(int[][] array, int r, int c) {
        int column = c - 1;
        int row = -1;
        for (int i = 0; i < r; i++) {
            for (int j = column; j >= 0; j--) {
                if (array[i][j] == 1) {
                    row = i;
                    column--;
                }
                else {
                    break;
                }
            }
        }
        return row;
    }
}
