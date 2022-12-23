package org.redquark.leetcode.patterns.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     * Time complexity - O(n ^ 2)
     * Space complexity - O(n)
     */
    public int lengthOfLIS(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Length of the array
        int n = nums.length;
        // Variable to keep track of the longest increase subsequence
        int maxLength = 0;
        // Lookup table to store the LIS at each index
        int[] lookup = new int[n];
        // Fill the array with default value which is 1 because the
        // minimum longest subsequence is 1
        Arrays.fill(lookup, 1);
        // Iterate the array from right to left to find out the increasing
        // sequence after the current index
        for (int i = n - 1; i >= 0; i--) {
            // Check for all the elements after the current element
            for (int j = i; j < n; j++) {
                // If the number at i is less than number at j, then
                // we will know it is increasing
                if (nums[i] < nums[j]) {
                    lookup[i] = Math.max(lookup[i], lookup[j] + 1);
                }
            }
        }
        // Find the maximum in the lookup table
        for (int element : lookup) {
            maxLength = Math.max(element, maxLength);
        }
        return maxLength;
    }
}
