package org.redquark.leetcode.patterns.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationsIITest {

    private final PermutationsII testObject = new PermutationsII();

    @Test
    public void testPermuteUnique() {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> expected = List.of(
                List.of(1, 1, 2),
                List.of(1, 2, 1),
                List.of(2, 1, 1)
        );
        assertEquals(expected, testObject.permuteUnique(nums));

        nums = new int[]{1, 2, 3};
        expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );
        assertEquals(expected, testObject.permuteUnique(nums));
    }
}