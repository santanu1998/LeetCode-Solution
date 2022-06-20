package com.LeetCode;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean answer = exist(board, word);
        System.out.println(answer);
    }
    private static boolean exist(char[][] board, String word) {
        char[] currentWord = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (currentWord[0] == board[i][j]) {
                    boolean[][] visted = new boolean[board.length][board[0].length];
                    if (dfs(board, currentWord, i, j, visted, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, char[] currentWord, int i, int j, boolean[][] visted, int index) {
        if (index == currentWord.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visted[i][j]) {
            return false;
        }
        if (board[i][j] != currentWord[index]) {
            return false;
        }
        visted[i][j] = true;
        if (dfs(board, currentWord, i - 1, j, visted, index + 1) ||
        dfs(board, currentWord, i + 1, j, visted, index + 1) ||
        dfs(board, currentWord, i, j - 1, visted, index + 1) ||
        dfs(board, currentWord, i, j + 1, visted, index + 1)) {
            return true;
        }
        visted[i][j] = false;
        return false;
    }
}
