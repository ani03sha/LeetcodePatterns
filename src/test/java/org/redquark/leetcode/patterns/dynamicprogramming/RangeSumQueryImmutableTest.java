package org.redquark.leetcode.patterns.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.redquark.leetcode.patterns.dynamicprogramming.RangeSumQueryImmutable.NumArray;

public class RangeSumQueryImmutableTest {

    @Test
    public void test() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        assertEquals(1, numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(-3, numArray.sumRange(0, 5));
    }
}