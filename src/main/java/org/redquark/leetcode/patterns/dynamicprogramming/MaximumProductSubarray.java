package org.redquark.leetcode.patterns.dynamicprogramming;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        // Variable to keep track of the overall max product
        int globalMax = nums[0];
        // Variable to keep track of the local maximum until
        // the current index
        int localMax = nums[0];
        // Variable to keep track of the local minimum until
        // the current index
        int localMin = nums[0];
        // Loop through the array
        for (int i = 1; i < nums.length; i++) {
            // Store localMax for future calculation purposes
            int tempMax = localMax;
            // Update the values of localMax and localMin, if required
            localMax = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * localMin));
            localMin = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * localMin));
            // Update the global max, if required
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
