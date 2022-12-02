package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /**
     * Time complexity - O(n * (2 ^ n))
     * Space complexity - O(n)
     */
    public List<List<String>> partition(String s) {
        // List to store the palindrome partitions
        List<List<String>> partitions = new ArrayList<>();
        // Special case
        if (s == null || s.isEmpty()) {
            return partitions;
        }
        // Perform backtracking on the string
        backtrack(s, new ArrayList<>(), 0, partitions);
        return partitions;
    }

    private void backtrack(String s, List<String> partition, int index, List<List<String>> partitions) {
        // Base case - when we have traversed the entire string
        if (index == s.length()) {
            partitions.add(new ArrayList<>(partition));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // If the candidate is palindrome then only we will
            // choose to perform backtracking on it
            if (isPalindrome(s, index, i)) {
                partition.add(s.substring(index, i + 1));
                backtrack(s, partition, i + 1, partitions);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String candidate, int start, int end) {
        while (start <= end) {
            if (candidate.charAt(start) != candidate.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
