package org.redquark.leetcode.patterns.dynamicprogramming;

public class CountingBits {

    public int[] countBits(int n) {
        // Special case
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        // Array to store the counted bits
        int[] countedBits = new int[n + 1];
        // Offset variable
        int offset = 1;
        // Loop through n
        for (int i = 1; i <= n; i++) {
            if (i == 2 * offset) {
                offset *= 2;
            }
            countedBits[i] = 1 + countedBits[i - offset];
        }
        return countedBits;
    }
}
