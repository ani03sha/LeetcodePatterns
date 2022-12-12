package org.redquark.leetcode.patterns.binarysearch;

public class MedianOfTwoSortedArrays {

    /**
     * Time complexity - (log(m + n))
     * Space complexity - O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Length of two arrays
        int x = nums1.length;
        int y = nums2.length;
        // If the length of nums1 is greater than nums2,
        // we will swap them
        if (x > y) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // Left and right pointers
        int left = 0;
        int right = x;
        // Loop until the two pointers meet
        while (left <= right) {
            // Get partitionX and partitionY
            int partitionX = left + (right - left) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            // Edge cases when there is nothing on left or right side
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
            // If we have found the correct position
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // For even sized combined array
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }
                // For odd sized combined arrays
                else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            }
            // If we are too far right of partitionX, we move left
            else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            }
            // If we are too far left of partitionX, we move right
            else {
                left = partitionX + 1;
            }
        }
        // Should never reach here
        throw new IllegalArgumentException("Invalid input!");
    }
}
