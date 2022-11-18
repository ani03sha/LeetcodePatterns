package org.redquark.leetcode.patterns.arrays;

public class RotateImage {

    /**
     * Time complexity - O(N * N)
     * Space complexity - O(1)
     */
    public int[][] rotate(int[][] matrix) {
        // Special case
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        // Order of the square matrix.
        int N = matrix.length;
        // Step 1 - transpose the matrix and swap the diagonally placed elements
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                // Swap the elements
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Now, reverse every row
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = temp;
            }
        }
        return matrix;
    }
}
