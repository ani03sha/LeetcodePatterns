package org.redquark.leetcode.patterns.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Time complexity - O(m * n)
     * Space complexity - O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // List to store the spiral order of matrix
        List<Integer> spiral = new ArrayList<>();
        // Special case
        if (matrix == null || matrix.length == 0) {
            return spiral;
        }
        // Dimensions of the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        // Pointers to traverse rows and columns
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        // Loop until we include all the elements in the matrix
        // to the list
        while (left <= right && top <= bottom) {
            // Move from left to right
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            // Update top pointer
            top++;
            // Move from top to bottom
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            // Update right pointer
            right--;
            // Break if we have reached out of bounds
            if (left > right || top > bottom) {
                break;
            }
            // Move from right to left
            for (int i = right; i >= left; i--) {
                spiral.add(matrix[bottom][i]);
            }
            // Update the bottom pointer
            bottom--;
            // Move from bottom to top
            for (int i = bottom; i >= top; i--) {
                spiral.add(matrix[i][left]);
            }
            // Update the left pointer
            left++;
        }
        return spiral;
    }
}
