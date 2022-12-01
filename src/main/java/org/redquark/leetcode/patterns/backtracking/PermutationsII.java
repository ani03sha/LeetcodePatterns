package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        // List to store the unique permutations
        List<List<Integer>> uniquePermutations = new ArrayList<>();
        // Special case
        if (nums == null || nums.length == 0) {
            return uniquePermutations;
        }
        // Sort the array. This is necessary to keep
        // track of duplicates by indices
        Arrays.sort(nums);

        // Perform backtracking
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], uniquePermutations);
        return uniquePermutations;
    }

    private void backtrack(int[] nums, List<Integer> temp, boolean[] visited, List<List<Integer>> uniquePermutations) {
        // Add the current combination to the final list if all
        // the elements are added in a certain order
        if (nums.length == temp.size()) {
            uniquePermutations.add(new ArrayList<>(temp));
        }
        // Consider for all the remaining elements
        else {
            // Check for elements in the array
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                    continue;
                }
                // Add current element to the list
                temp.add(nums[i]);
                // Mark this element as visited
                visited[i] = true;
                // Backtrack with this temp list
                backtrack(nums, temp, visited, uniquePermutations);
                // Un-mark this element as visited
                visited[i] = false;
                // Remove the previously added element
                temp.remove(temp.size() - 1);
            }
        }
    }
}
