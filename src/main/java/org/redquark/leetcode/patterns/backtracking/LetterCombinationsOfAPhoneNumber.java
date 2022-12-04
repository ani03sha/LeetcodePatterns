package org.redquark.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    /**
     * Time complexity - O(n * (2 ^ n))
     * Space complexity - O(n)
     */
    public List<String> letterCombinations(String digits) {
        // List to store the combinations
        List<String> combinations = new ArrayList<>();
        // Special case
        if (digits == null || digits.isEmpty()) {
            return combinations;
        }
        String[] mappings = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        // Perform backtracking
        backtrack(digits, 0, "", mappings, combinations);
        return combinations;
    }

    private void backtrack(String digits, int index, String combination, String[] mappings, List<String> combinations) {
        // If we have covered all the characters in the string
        if (index == digits.length()) {
            combinations.add(combination);
            return;
        }
        // Characters present at the index represented by the current index
        String characters = mappings[digits.charAt(index) - '0'];
        // Loop for every character in the characters string
        for (char character : characters.toCharArray()) {
            backtrack(digits, index + 1, combination + character, mappings, combinations);
        }
    }
}
