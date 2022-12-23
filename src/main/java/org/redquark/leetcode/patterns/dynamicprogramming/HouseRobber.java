package org.redquark.leetcode.patterns.dynamicprogramming;

public class HouseRobber {

    public int rob(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Total number of houses
        int n = nums.length;
        // More special cases
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // Lookup table to store the robbed money
        int[] lookup = new int[n + 1];
        // Initialized the array
        lookup[0] = 0;
        lookup[1] = nums[0];
        lookup[2] = Math.max(nums[0], nums[1]);
        // Populate for remaining positions
        for (int i = 3; i <= n; i++) {
            lookup[i] = Math.max(lookup[i - 1], lookup[i - 2] + nums[i - 1]);
        }
        return lookup[n];
    }
}
