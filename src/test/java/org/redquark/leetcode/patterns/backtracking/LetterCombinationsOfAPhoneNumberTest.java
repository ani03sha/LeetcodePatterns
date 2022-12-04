package org.redquark.leetcode.patterns.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterCombinationsOfAPhoneNumberTest {

    private final LetterCombinationsOfAPhoneNumber testObject = new LetterCombinationsOfAPhoneNumber();

    @Test
    public void testLetterCombinations() {
        String digits = "23";
        List<String> expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expected, testObject.letterCombinations(digits));

        digits = "";
        expected = List.of();
        assertEquals(expected, testObject.letterCombinations(digits));

        digits = "2";
        expected = List.of("a", "b", "c");
        assertEquals(expected, testObject.letterCombinations(digits));
    }
}