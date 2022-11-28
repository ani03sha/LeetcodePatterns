package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    /**
     * Time complexity - O(n * (2 ^ n))
     * Space complexity - (n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        // List to store all the subsets
        List<List<Integer>> powerSet = new ArrayList<>();
        // Special case
        if (nums == null || nums.length == 0) {
            return powerSet;
        }
        // Sort the array
        Arrays.sort(nums);
        // Perform backtracking
        backtrack(nums, new ArrayList<>(), powerSet, 0);
        return powerSet;
    }

    private void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> powerSet, int start) {
        // Add the current temp list to the power set
        powerSet.add(new ArrayList<>(temp));
        // Perform backtracking on nums array
        for (int i = start; i < nums.length; i++) {
            // Add the current element to the list
            temp.add(nums[i]);
            // Backtrack on the next index
            backtrack(nums, temp, powerSet, i + 1);
            // Remove the current element from the set
            temp.remove(temp.size() - 1);
        }
    }
}
