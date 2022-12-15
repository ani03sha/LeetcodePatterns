package org.redquark.leetcode.patterns.bitmanipultation;

public class SingleNumber {

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int singleNumber(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array should have at least one element");
        }
        // Variable to store XORs of the array elements
        int xor = nums[0];
        // Traverse through the remaining elements
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
