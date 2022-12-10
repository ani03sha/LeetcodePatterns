package org.redquark.leetcode.patterns.binarysearch;

public class FindPeakElement {

    /**
     * Time complexity - O(log(n))
     * Space complexity - O(1)
     */
    public int findPeakElement(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("There should be at least one element in the array");
        }
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;
        // Loop until the two pointers meet
        while (left < right) {
            // Middle index
            int middle = left + (right - left) / 2;
            // Check for the middle and its right element
            if (nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
