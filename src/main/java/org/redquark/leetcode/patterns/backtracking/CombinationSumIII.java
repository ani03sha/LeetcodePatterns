package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        // List to store all the sum combinations
        List<List<Integer>> sumCombinations = new ArrayList<>();
        // Special cases
        if (k <= 0 || n <= 0) {
            return sumCombinations;
        }
        // Perform backtracking
        backtrack(n, k, new ArrayList<>(), 1, sumCombinations);
        return sumCombinations;
    }

    private void backtrack(int target, int k, List<Integer> sumCombination, int current, List<List<Integer>> sumCombinations) {
        // If the sum is achieved and the list has exactly k elements
        if (target == 0 && sumCombination.size() == k) {
            sumCombinations.add(new ArrayList<>(sumCombination));
            return;
        }
        // Traverse through elements from 1 to n to check for
        // various combinations
        for (int i = current; i <= 9; i++) {
            // Add current element to the list
            sumCombination.add(i);
            // Backtrack with updated state
            backtrack(target - i, k, sumCombination, i + 1, sumCombinations);
            // Remove the choice we made before
            sumCombination.remove(sumCombination.size() - 1);
        }
    }
}
