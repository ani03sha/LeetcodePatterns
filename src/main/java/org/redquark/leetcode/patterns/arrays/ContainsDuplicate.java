package org.redquark.leetcode.patterns.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            return false;
        }
        // Set to store the elements in the array.
        // Since a set guarantees unique values, we
        // will be able to determine if the array
        // contains any duplicates
        final Set<Integer> seen = new HashSet<>();
        // Loop through the array and add elements to
        // the set
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}
