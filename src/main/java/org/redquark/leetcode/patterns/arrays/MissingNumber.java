package org.redquark.leetcode.patterns.arrays;

public class MissingNumber {

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int missingNumber(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array should have at least one element");
        }
        // Variable to keep track of array sum
        int sum = 0;
        // Find sum of all elements in the array
        for (int num : nums) {
            sum += num;
        }
        // Length of the array
        int n = nums.length;
        // Since the array can only have elements from 0 to n, we
        // can leverage the sum formula (1 + 2 + 3 + ... + n) to
        // find the missing number.
        return n * (n + 1) / 2 - sum;
    }
}
