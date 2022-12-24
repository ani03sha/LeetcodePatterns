package org.redquark.leetcode.patterns.dynamicprogramming;

public class PalindromicSubstrings {

    /**
     * Time complexity - O(n ^ 2)
     * Space complexity - O(1)
     */
    public int countSubstrings(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // Variable to keep track of all palindromic substrings
        int palindromicCount = 0;
        // Loop through the string
        for (int i = 0; i < s.length(); i++) {
            // For odd length substrings
            palindromicCount += expandFromMiddle(s, i, i);
            // For even length substrings
            palindromicCount += expandFromMiddle(s, i, i + 1);
        }
        return palindromicCount;
    }

    private int expandFromMiddle(String s, int left, int right) {
        // Variable to keep track of palindromic substrings
        // in the current window
        int count = 0;
        // Check for palindromic property
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
