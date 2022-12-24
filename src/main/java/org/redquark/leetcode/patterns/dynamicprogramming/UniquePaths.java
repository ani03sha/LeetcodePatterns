package org.redquark.leetcode.patterns.dynamicprogramming;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        // Special case
        if (m <= 0 || n <= 0) {
            return 0;
        }
        // Lookup table to store ways
        int[][] lookup = new int[m][n];
        // Base initialization for first row and column
        for (int i = 0; i < m; i++) {
            lookup[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            lookup[0][j] = 1;
        }
        // Loop from top-left to bottom-right
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                lookup[i][j] = lookup[i - 1][j] + lookup[i][j - 1];
            }
        }
        return lookup[m - 1][n - 1];
    }
}
