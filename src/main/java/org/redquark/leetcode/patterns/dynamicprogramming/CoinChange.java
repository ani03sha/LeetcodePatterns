package org.redquark.leetcode.patterns.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // Special case
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        // Lookup table to store the count of coins to
        // make a certain amount
        int[] lookup = new int[amount + 1];
        // Populate this table with the default values
        Arrays.fill(lookup, Integer.MAX_VALUE);
        // Zero coins are needed to make zero amount
        lookup[0] = 0;
        // Populate the lookup table
        for (int i = 1; i <= amount; i++) {
            // Loop through the coins array
            for (int coin : coins) {
                // We will only take coins which are less than the
                // amount we are trying to make currently
                if (coin <= i) {
                    int difference = lookup[i - coin];
                    // If we have calculated this difference before
                    if (difference != Integer.MAX_VALUE) {
                        lookup[i] = Math.min(lookup[i], difference + 1);
                    }
                }
            }
        }
        return lookup[amount] == Integer.MAX_VALUE ? -1 : lookup[amount];
    }
}
