package org.redquark.leetcode.patterns.binarysearch;

public class FindTheDuplicateNumber {

    /**
     * Time complexity - O(n * log(n))
     * Space complexity - O(1)
     */
    public int findDuplicate(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;
        // Variable to hold the duplicate
        int duplicate = -1;
        // Loop until the left and right pointers meet
        while (left <= right) {
            // Middle index
            int middle = left + (right - left) / 2;
            // Count of numbers that are less than or equal to
            // the current number at middle index
            int count = 0;
            for (int num : nums) {
                if (num <= middle) {
                    count++;
                }
            }
            if (count > middle) {
                duplicate = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return duplicate;
    }
}
