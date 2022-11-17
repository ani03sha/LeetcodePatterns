package org.redquark.leetcode.patterns.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SetMatrixZeroesTest {

    private final SetMatrixZeroes testObject = new SetMatrixZeroes();

    @Test
    public void testSetZeroes() {
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] expected = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        assertArrayEquals(expected, testObject.setZeroes(matrix));

        matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        expected = new int[][]{
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        };
        assertArrayEquals(expected, testObject.setZeroes(matrix));
    }
}