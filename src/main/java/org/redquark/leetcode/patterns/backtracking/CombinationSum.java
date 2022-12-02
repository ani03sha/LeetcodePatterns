package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    /**
     * Time complexity - O(n * (2 ^ n))
     * Space complexity - O(n)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // List to store all the sum combinations
        List<List<Integer>> sumCombinations = new ArrayList<>();
        // Special case
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return sumCombinations;
        }
        // Sort the array
        Arrays.sort(candidates);
        // Perform backtracking
        backtrack(candidates, target, 0, new ArrayList<>(), sumCombinations);
        return sumCombinations;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> sumCombination, List<List<Integer>> sumCombinations) {
        // Special case - when the target to achieve is zero
        if (target == 0) {
            sumCombinations.add(new ArrayList<>(sumCombination));
            return;
        }
        // Loop through the remaining elements
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                // Add current element to the list
                sumCombination.add(candidates[i]);
                // Backtrack with the updated target
                backtrack(candidates, target - candidates[i], i, sumCombination, sumCombinations);
                // Remove the choice we made
                sumCombination.remove(sumCombination.size() - 1);
            }
        }
    }
}
