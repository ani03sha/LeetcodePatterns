package org.redquark.leetcode.patterns.binarysearch;

public class SearchA2DMatrix {

    /**
     * Time complexity - O(m * log(n))
     * Space complexity - O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Special case
        if (matrix == null) {
            return false;
        }
        // Loop through all the rows
        for (int[] row : matrix) {
            // Check if the current row may contain the target
            if (row[0] <= target && row[row.length - 1] >= target) {
                // Binary search on the current row
                return binarySearch(row, target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;
        // Loop until the pointers meet
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return true;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
