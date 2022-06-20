package com.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<String>> result = solveNQueens(n);
        System.out.println(result);
    }
    /*
    private static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        depthFirstSearch(0, board, result);
        return result;
    }

    private static boolean validate(char[][] board, int row, int column) {
        int duplicateRow = row;
        int duplicateColumn = column;
        while(row >= 0 && column >= 0) {
            if(board[row][column] == 'Q') {
                return false;
            }
            row--;
            column--;
        }

        row = duplicateRow;
        column = duplicateColumn;
        while(column >= 0) {
            if(board[row][column] == 'Q') {
                return false;
            }
            column--;
        }

        row = duplicateRow;
        column = duplicateColumn;
        while(column >= 0 && row < board.length) {
            if(board[row][column] == 'Q') {
                return false;
            }
            column--;
            row++;
        }
        return true;
    }

    private static void depthFirstSearch(int column, char[][] board, List<List<String>> result) {
        if(column == board.length) {
            result.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++) {
            if(validate(board, row, column)) {
                board[row][column] = 'Q';
                depthFirstSearch(column+1, board, result);
                board[row][column] = '.';
            }
        }
    }



    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] chars : board) {
            String str = new String(chars);
            res.add(str);
        }
        return res;
    }
    */

    private static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        solve(0, board, result, leftRow, lowerDiagonal, upperDiagonal);
        return result;
    }



    private static void solve(int column, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if(column == board.length) {
            res.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++) {
            if(leftRow[row] == 0 && lowerDiagonal[row + column] == 0 && upperDiagonal[board.length -1 + column - row] == 0) {
                board[row][column] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + column] = 1;
                upperDiagonal[board.length-1 + column - row] = 1;
                solve(column + 1, board, res, leftRow, lowerDiagonal, upperDiagonal );
                board[row][column] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + column] = 0;
                upperDiagonal[board.length - 1 + column - row] = 0;
            }
        }
    }


    private static List<String> construct(char[][] board) {
        List<String> result = new LinkedList<String>();
        for (char[] chars : board) {
            String str = new String(chars);
            result.add(str);
        }
        return result;
    }
}
