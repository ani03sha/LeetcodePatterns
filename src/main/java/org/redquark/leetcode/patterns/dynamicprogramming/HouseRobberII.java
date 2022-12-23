package org.redquark.leetcode.patterns.dynamicprogramming;

public class HouseRobberII {

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
        // We need to take two cases in consideration, either we choose the
        // last house or we don't choose it
        return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
    }

    private int robHelper(int[] nums, int start, int end) {
        // Variables to store the amount when a certain house is
        // included or excluded
        int included = 0;
        int excluded = 0;
        // Loop through the array from start to end
        for (int i = start; i <= end; i++) {
            int temp = Math.max(included, excluded);
            // Include current element and previously excluded element
            included = excluded + nums[i];
            // Max of included and excluded elements of previous iteration
            excluded = temp;
        }
        return Math.max(included, excluded);
    }
}
