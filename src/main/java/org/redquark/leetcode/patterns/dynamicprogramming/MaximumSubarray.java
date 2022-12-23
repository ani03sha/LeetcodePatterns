package org.redquark.leetcode.patterns.dynamicprogramming;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        // Variable to keep track of the global maximum
        int globalMax = nums[0];
        // Variable to keep track of the local max which
        // is the sum of the current subarray
        int localMax = nums[0];
        // Loop through the array
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }
}
