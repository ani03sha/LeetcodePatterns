package org.redquark.leetcode.patterns.dynamicprogramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int maxProfit(int[] prices) {
        // Special case
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // Length of the array
        int n = prices.length;
        // Array to keep track of buying prices and selling prices
        int[] buyingPrices = new int[n];
        int[] sellingPrices = new int[n];
        // Minimum buying price is filled as a default value
        Arrays.fill(buyingPrices, Integer.MIN_VALUE);
        // Buying price for the first day
        buyingPrices[0] = -prices[0];
        // Calculate the profits for each day
        for (int i = 1; i < n; i++) {
            // We can either pick the current stock, or we can skip this
            // and buy the previous stock to honor one-day cooldown period.
            buyingPrices[i] = Math.max(buyingPrices[i - 1], (i > 1 ? sellingPrices[i - 2] : 0) - prices[i]);
            // There is no restriction on the selling of stocks
            sellingPrices[i] = Math.max(sellingPrices[i - 1], buyingPrices[i - 1] + prices[i]);
        }
        return sellingPrices[n - 1];
    }
}
