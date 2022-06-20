package com.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = 9;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }
        */
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        printArray(board);
    }
    private static void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    private static boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++) {
                        //trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            //Put c for this cell

                            if(solve(board))
                                return true;
                                //If it's the solution return true
                            else
                                board[i][j] = '.';
                            //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int column, char ch){
        for(int i = 0; i < 9; i++) {
            if(board[i][column] != '.' && board[i][column] == ch)
                return false;
            //check row
            if(board[row][i] != '.' && board[row][i] == ch)
                return false;
            //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (column / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == ch)
                return false;
            //check 3*3 block
        }
        return true;
    }
    private static void printArray(char[][] board) {
        solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
