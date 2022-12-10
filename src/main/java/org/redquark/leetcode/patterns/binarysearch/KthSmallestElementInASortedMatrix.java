package org.redquark.leetcode.patterns.binarysearch;

public class KthSmallestElementInASortedMatrix {

    /**
     * Time complexity - O(n * log(n))
     * Space complexity - O(1)
     */
    public int kthSmallest(int[][] matrix, int k) {
        // Special case
        if (matrix == null || matrix.length * matrix.length < k) {
            throw new IllegalArgumentException("Invalid input!");
        }
        // Order of the matrix
        int n = matrix.length;
        // Smallest number in the matrix
        int low = matrix[0][0];
        // Greatest number in the matrix
        int high = matrix[n - 1][n - 1];
        // The range for our binary search algorithm would be low and high
        while (low < high) {
            // Get the middle of the range
            int middle = low + (high - low) / 2;
            // Count the number of elements smaller or equal to the middle
            // element
            int column = n - 1;
            int count = 0;
            for (int[] row : matrix) {
                // Start from the right most end and find the column where
                // element is less than or equal to the middle element.
                while (column >= 0 && row[column] > middle) {
                    column--;
                }
                count += (column + 1);
            }
            if (count < k) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
}
