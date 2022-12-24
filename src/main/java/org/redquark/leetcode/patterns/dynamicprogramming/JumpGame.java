package org.redquark.leetcode.patterns.dynamicprogramming;

public class JumpGame {

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public boolean canJump(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            return false;
        }
        // Length of the array
        int n = nums.length;
        // We can always reach to the end of the array,
        // if we are already at the last index
        int lastGoodIndex = n - 1;
        // Loop from right to left
        for (int i = n - 1; i >= 0; i--) {
            // From current index, we need a value which
            // can help us in reaching lastGoodIndex
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        return lastGoodIndex == 0;
    }
}
