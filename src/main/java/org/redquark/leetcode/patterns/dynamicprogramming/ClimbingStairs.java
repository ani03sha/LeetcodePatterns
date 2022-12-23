package org.redquark.leetcode.patterns.dynamicprogramming;

public class ClimbingStairs {

    public int climbStairs(int n) {
        // Special cases
        if (n < 3) {
            return n;
        }
        // Lookup table to store the number of ways we can reach
        // to the n-th stair
        int[] lookup = new int[n + 1];
        // Initialize with the base cases
        lookup[0] = 0;
        lookup[1] = 1;
        lookup[2] = 2;
        // Populate the remaining array
        for (int i = 3; i <= n; i++) {
            lookup[i] = lookup[i - 2] + lookup[i - 1];
        }
        return lookup[n];
    }
}
