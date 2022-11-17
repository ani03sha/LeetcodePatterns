package org.redquark.leetcode.patterns.arrays;

public class SetMatrixZeroes {

    /**
     * Time complexity - O(m*n)
     * Space complexity - O(1)
     */
    public int[][] setZeroes(int[][] matrix) {
        // Special case
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        // Dimensions of the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        // Flags to check if zeroes are present in first
        // row and first column
        boolean firstRow = false;
        boolean firstColumn = false;
        // Loop through the matrix to process first row
        // and first column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // For first row
                    if (i == 0) {
                        firstRow = true;
                    }
                    // For first column
                    if (j == 0) {
                        firstColumn = true;
                    }
                    // Set the zero in the first row and column
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // Traverse for all cells excepts the ones in the first
        // row and the first column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // If any element from the first row or column is zero
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // For first row
        if (firstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        // For first column
        if (firstColumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
