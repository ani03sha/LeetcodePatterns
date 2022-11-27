package org.redquark.leetcode.patterns.backtracking;

public class WordSearch {

    /**
     * Time complexity - O(m * n * (4 ^ k))
     * Space complexity - O(k)
     * k being the length of the word
     */
    public boolean exist(char[][] board, String word) {
        // Special case
        if (board == null || board.length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        // Dimensions of the board
        int m = board.length;
        int n = board[0].length;
        // Perform backtracking for every combination of cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, m, n, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int m, int n, int index) {
        // If we have reached to the end of the word, it means we
        // have found the word
        if (index == word.length()) {
            return true;
        }
        // Check for out of bounds conditions
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index) || board[i][j] == '#') {
            return false;
        }
        // Get the current character in the board
        char c = board[i][j];
        // Mark this cell as visited
        board[i][j] = '#';
        // Check in all four directions
        boolean w = backtrack(board, word, i + 1, j, m, n, index + 1);
        boolean x = backtrack(board, word, i, j + 1, m, n, index + 1);
        boolean y = backtrack(board, word, i - 1, j, m, n, index + 1);
        boolean z = backtrack(board, word, i, j - 1, m, n, index + 1);
        // Mark the current cell as unvisited
        board[i][j] = c;
        return w || x || y || z;
    }
}
