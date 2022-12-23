package org.redquark.leetcode.patterns.dynamicprogramming;

public class RangeSumQueryImmutable {

    static class NumArray {

        private final int[] cumulativeSums;

        public NumArray(int[] nums) {
            // Length of the nums
            int n = nums.length;
            // Initialize the cumulative sums array
            this.cumulativeSums = new int[n + 1];
            // Populate this array
            for (int i = 1; i <= n; i++) {
                this.cumulativeSums[i] = this.cumulativeSums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return this.cumulativeSums[right + 1] - this.cumulativeSums[left];
        }
    }
}
