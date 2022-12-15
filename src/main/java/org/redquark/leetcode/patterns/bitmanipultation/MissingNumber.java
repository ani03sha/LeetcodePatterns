package org.redquark.leetcode.patterns.bitmanipultation;

public class MissingNumber {

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int missingNumber(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        // We will XOR every number with itself in the array from 1 to n.
        // (x XOR x = 0 and x XOR 0 = x)
        int xor = nums.length;
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            // XOR with the current index (as array will contain elements from 0 to n)
            xor ^= i;
            // This XOR will negate the effect of the nums[i]
            xor ^= nums[i];
        }
        return xor;
    }
}
