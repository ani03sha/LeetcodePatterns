package org.redquark.leetcode.patterns.dynamicprogramming;

public class DecodeWays {

    public int numDecodings(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // Length of the string
        int n = s.length();
        // Lookup table to store the ways for a certain index
        int[] lookup = new int[n + 1];
        // Base initialization
        lookup[0] = 1;
        lookup[1] = s.charAt(0) == '0' ? 0 : 1;
        // Populate the remaining table
        for (int i = 2; i <= n; i++) {
            // Get the single digit from the string
            int singleDigit = Integer.parseInt(s.substring(i - 1, i));
            // If this is a valid digit
            if (singleDigit > 0) {
                lookup[i] += lookup[i - 1];
            }
            // Get the two digits
            int doubleDigits = Integer.parseInt(s.substring(i - 2, i));
            if (doubleDigits >= 10 && doubleDigits <= 26) {
                lookup[i] += lookup[i - 2];
            }
        }
        return lookup[n];
    }
}
