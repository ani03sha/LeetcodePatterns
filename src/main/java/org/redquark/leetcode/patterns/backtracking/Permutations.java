package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        // List to store the all permutations
        List<List<Integer>> permutations = new ArrayList<>();
        // Special case
        if (nums == null || nums.length == 0) {
            return permutations;
        }
        // Perform backtracking
        backtrack(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> permutations) {
        // If our index has reached the length of the nums, it means
        // we have encountered all the numbers for one combination
        if (temp.size() == nums.length) {
            permutations.add(new ArrayList<>(temp));
        }
        // For all the other combinations
        else {
            for (int num : nums) {
                // Skip if the temp list contains the number
                if (temp.contains(num)) {
                    continue;
                }
                // Add current element to the list
                temp.add(num);
                // Backtrack on the next number
                backtrack(nums, temp, permutations);
                // Remove the previously added element
                temp.remove(temp.size() - 1);
            }
        }
    }
}
