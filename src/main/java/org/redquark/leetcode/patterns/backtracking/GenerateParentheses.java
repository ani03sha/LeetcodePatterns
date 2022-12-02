package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * Time complexity - ((4 ^ n) / sqrt(n))
     * Space complexity - ((4 ^ n) / sqrt(n))
     */
    public List<String> generateParenthesis(int n) {
        // List to store the combinations of parentheses
        List<String> combinations = new ArrayList<>();
        // Special case
        if (n <= 0) {
            return combinations;
        }
        // Perform backtracking
        backtrack(n, new StringBuilder(), 0, 0, combinations);
        return combinations;
    }

    private void backtrack(int n, StringBuilder combination, int open, int close, List<String> combinations) {
        // Add the combination only if the count of open and close parentheses are same
        if (combination.length() == 2 * n) {
            combinations.add(combination.toString());
            return;
        }
        // Add open parentheses until we reach n
        if (open < n) {
            combination.append('(');
            backtrack(n, combination, open + 1, close, combinations);
            combination.deleteCharAt(combination.length() - 1);
        }
        // Add close parentheses until they are equal to the
        // open parentheses count
        if (close < open) {
            combination.append(')');
            backtrack(n, combination, open, close + 1, combinations);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
