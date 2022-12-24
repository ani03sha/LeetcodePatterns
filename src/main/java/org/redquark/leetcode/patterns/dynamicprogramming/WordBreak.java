package org.redquark.leetcode.patterns.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /**
     * Time complexity - O(n^3)
     * Space complexity - O(n)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // Special case
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        // Length of string
        int n = s.length();
        // Add the words to the set so that contains becomes O(1)
        Set<String> words = new HashSet<>(wordDict);
        // Lookup table to check if the string ending at the current
        // index is present in the dictionary or not
        boolean[] lookup = new boolean[n + 1];
        // Base initialization - for null string which is always
        // present in the dictionary
        lookup[0] = true;
        // Loop through the string
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if the substring between index j and
                // index i is present
                if (lookup[j] && words.contains(s.substring(j, i))) {
                    lookup[i] = true;
                    break;
                }
            }
        }
        return lookup[n];
    }
}
