package org.redquark.leetcode.patterns.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheDuplicateNumberTest {

    FindTheDuplicateNumber testObject = new FindTheDuplicateNumber();

    @Test
    public void testFindDuplicate() {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        assertEquals(2, testObject.findDuplicate(nums));

        nums = new int[]{3, 1, 3, 4, 2};
        assertEquals(3, testObject.findDuplicate(nums));
    }
}