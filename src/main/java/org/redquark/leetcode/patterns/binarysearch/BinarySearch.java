package org.redquark.leetcode.patterns.binarysearch;

public class BinarySearch {

    /**
     * Time complexity - O(log(n))
     * Space complexity - O(1)
     */
    public int search(int[] nums, int target) {
        // Special case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;
        // Loop until both pointers meet
        while (left <= right) {
            // Middle index
            int middle = left + (right - left) / 2;
            // Check if the element at the middle index,
            // is the correct element
            if (nums[middle] == target) {
                return middle;
            }
            // If the target is smaller than the element at
            // the middle index, then we will discard the right
            // half and will search in the left half
            else if (nums[middle] > target) {
                right = middle - 1;
            }
            // If the target is greater than the element at
            // the middle index, then we will discard the left
            // halft and will search in the right half
            else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
