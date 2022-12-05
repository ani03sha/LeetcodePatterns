package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        // List to store the positions of solutions
        List<List<String>> positions = new ArrayList<>();
        // Special case
        if (n <= 0) {
            return positions;
        }
        // Board to place queens
        int[][] board = new int[n][n];
        // Perform backtracking
        backtrack(board, 0, positions);
        return positions;
    }

    private void backtrack(int[][] board, int column, List<List<String>> positions) {
        // Special case
        if (column == board.length) {
            positions.add(addPosition(board));
            return;
        }
        // Traverse through all the rows
        for (int row = 0; row < board[0].length; row++) {
            // Check if we can place the queen in the current cell
            if (canPlace(board, row, column)) {
                board[row][column] = 1;
                backtrack(board, column + 1, positions);
                board[row][column] = 0;
            }
        }
    }

    private boolean canPlace(int[][] board, int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = column; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private List<String> addPosition(int[][] board) {
        List<String> position = new ArrayList<>();
        for (int[] b : board) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < board[0].length; i++) {
                if (b[i] == 1) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            position.add(s.toString());
        }
        return position;
    }
}
