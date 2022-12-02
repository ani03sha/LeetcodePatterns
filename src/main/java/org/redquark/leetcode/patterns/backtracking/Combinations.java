package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        // List to store all the combinations
        List<List<Integer>> combinations = new ArrayList<>();
        // Special case
        if (n <= 0 || k <= 0) {
            return combinations;
        }
        // Perform backtracking
        backtrack(n, k, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtrack(int n, int k, int current, List<Integer> combination, List<List<Integer>> combinations) {
        // Base case, when the size of combination is equal to the value of k
        if (combination.size() == k) {
            // Add deep copy of the combination to the
            // list of all combinations
            combinations.add(new ArrayList<>(combination));
        }
        // Loop through all the remaining numbers
        for (int i = current; i <= n; i++) {
            // Add the current element to the current combination
            combination.add(i);
            // Backtrack for the next state
            backtrack(n, k, i + 1, combination, combinations);
            // Remove the element added in the previous step
            combination.remove(combination.size() - 1);
        }
    }
}
