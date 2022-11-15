package org.redquark.leetcode.patterns.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // List to store the disappeared numbers
        final List<Integer> disappearedNumbers = new ArrayList<>();
        // Special case
        if (nums == null || nums.length == 0) {
            return disappearedNumbers;
        }
        // Length of the array
        int n = nums.length;
        // Traverse through the array
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            // Negate the value present at the index if it is positive
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        // At this point, the positive values in the array will be present
        // at the indices which are disappeared numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                disappearedNumbers.add(i + 1);
            }
        }
        return disappearedNumbers;
    }
}
