package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    /**
     * Time complexity - O(n * (2 ^ n))
     * Space complexity - (n)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
        // Add all the current elements in the temp list to the power set
        powerSet.add(new ArrayList<>(temp));
        // Perform backtracking for every combination
        for (int i = start; i < nums.length; i++) {
            // Skip the duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, temp, powerSet, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
