package org.redquark.leetcode.patterns.dynamicprogramming;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return s;
        }
        // Start and end pointers for the sliding window
        int start = 0;
        int end = 0;
        // Loop through the string
        for (int i = 0; i < s.length(); i++) {
            // Get the longest palindromic substring for odd length
            int oddLength = expandFromCenter(s, i, i);
            // Get the longest palindromic substring for even length
            int evenLength = expandFromCenter(s, i, i + 1);
            // Find the maximum of the both lengths
            int max = Math.max(oddLength, evenLength);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        // Base case
        if (left > right) {
            return 0;
        }
        // Move from center to either side to find out the
        // palindromic string
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
