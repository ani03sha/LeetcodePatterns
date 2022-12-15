package org.redquark.leetcode.patterns.bitmanipultation;

public class CountingBits {

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int[] countBits(int n) {
        // Special case
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        // Array to store all the count of bits
        int[] bitCounts = new int[n + 1];
        // Below pattern is followed
        /*
             0 - 0
             1 - 1
             2 - 10 - 1
             3 - 11 - 2
             4 - 100 - 1
             5 - 101 - 2
             6 - 110 - 2
             7 - 111 - 3
             8 - 1000 - 1
             9 - 1001 - 2
             10 - 1010 - 2
             11 - 1011 - 3
             12 - 1100 - 2
             13 - 1101 - 3
             14 - 1110 - 3
             15 - 1111 - 4
        */
        // Variable to keep track of the offset
        int offset = 1;
        // Loop from 0 to n
        for (int i = 1; i <= n; i++) {
            if (i == offset * 2) {
                offset *= 2;
            }
            bitCounts[i] = 1 + bitCounts[i - offset];
        }
        return bitCounts;
    }
}
