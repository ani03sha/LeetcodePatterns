package org.redquark.leetcode.patterns.arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int[] productExceptSelfSolutionOne(int[] nums) {
        // Special case
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array cannot be null and its size should be at least 2.");
        }
        // Length of the array
        int n = nums.length;
        // Array to store the product of all elements before
        // the current element in the original array
        int[] leftProducts = new int[n];
        // Since there is no element before the first element
        // we will take the product of all elements before it
        // as 1.
        leftProducts[0] = 1;
        // Populate the array for remaining places
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        // Array to store the product of all elements after
        // the current element in the original array
        int[] rightProducts = new int[n];
        // Since there is no element after the last element
        // we will take the product of all elements after it
        // as 1.
        rightProducts[n - 1] = 1;
        // Populate the array for remaining places
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        // Array to store the final output
        int[] products = new int[n];
        // Loop through the left and right array and
        // multiply the current elements from both arrays
        for (int i = 0; i < n; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }
        return products;
    }

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int[] productExceptSelfSolutionTwo(int[] nums) {
        // Special case
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array cannot be null and its size should be at least 2.");
        }
        // Length of the array
        int n = nums.length;
        // Array to store the final output
        int[] products = new int[n];
        // Variable to keep track of the cumulative product
        int cumulativeProduct = 1;
        // Since there is no element before the first element
        // we will take the product of all elements before it
        // as 1.
        products[0] = cumulativeProduct;
        // For traversing from left to right, we will assign
        // the first element in the products array to 1
        // (similar to what we did in the leftProducts array).
        for (int i = 1; i < n; i++) {
            cumulativeProduct *= nums[i - 1];
            products[i] = cumulativeProduct;
        }
        // Reset the cumulative product
        cumulativeProduct = 1;
        // For traversing from right to left, we will leave
        // the last element in the products array as is
        // (similar to what we did in the rightProducts array).
        for (int i = n - 1; i >= 0; i--) {
            products[i] *= cumulativeProduct;
            cumulativeProduct *= nums[i];
        }
        return products;
    }
}
