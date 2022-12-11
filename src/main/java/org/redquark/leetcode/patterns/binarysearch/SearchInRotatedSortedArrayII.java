package org.redquark.leetcode.patterns.binarysearch;

public class SearchInRotatedSortedArrayII {

    /**
     * Time complexity - O(log(n))
     * Space complexity - O(1)
     */
    public boolean search(int[] nums, int target) {
        // Special case
        if (nums == null || nums.length == 0) {
            return false;
        }
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;
        // Loop until we find the target
        while (left <= right) {
            // Middle index
            int middle = left + (right - left) / 2;
            // If the element at the middle index is equal
            // to the target, we return true
            if (nums[middle] == target) {
                return true;
            }
            // If the left half is correctly sorted
            else if (nums[left] < nums[middle]) {
                // Check if the number lies in the left half
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            // If the left half is not correctly sorted
            else if (nums[left] > nums[middle]) {
                // Check if the number lies in the right half
                if (target > nums[middle] && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                // Move the left pointer ahead
                left++;
            }
        }
        return false;
    }
}
