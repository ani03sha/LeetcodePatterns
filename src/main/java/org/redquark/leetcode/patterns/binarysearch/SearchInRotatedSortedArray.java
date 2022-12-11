package org.redquark.leetcode.patterns.binarysearch;

public class SearchInRotatedSortedArray {

    /**
     * Time complexity - O(log(n))
     * Space complexity - O(1)
     */
    public int search(int[] nums, int target) {
        // Special case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // Length of the array
        int n = nums.length;
        // Left and right pointers
        int left = 0;
        int right = n - 1;
        // Loop until we find the pivot index
        while (left < right) {
            // Middle index
            int middle = left + (right - left) / 2;
            // Compare the element in the middle with the element
            // at the end of the array
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        // At this point, the left index will represent the pivot index
        int pivot = left;
        left = 0;
        right = n - 1;
        // Now, we will determine in which part of array, our target
        // is present
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot;
        }
        // Perform normal binary search
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
