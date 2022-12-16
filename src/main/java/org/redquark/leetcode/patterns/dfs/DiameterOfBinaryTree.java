package org.redquark.leetcode.patterns.dfs;

public class DiameterOfBinaryTree {

    /**
     * Time complexity - O(n ^ 2)
     * Space complexity - O(n)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // Special case
        if (root == null) {
            return 0;
        }
        // Get left and right heights of the tree
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // Get the left and right diameters
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        // Overall diameter will be max of
        // 1. Left diameter
        // 2. Right diameter
        // 3. 1 + leftHeight + rightHeight, passing through the root
        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    private int getHeight(TreeNode root) {
        // Special case
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int diameterOfBinaryTreeOptimal(TreeNode root) {
        // Variable to keep track of the maximum diameter.
        // Since values in Java are not passed by reference,
        // I am using array of one element
        int[] diameter = new int[1];
        // Call the modified height function
        getHeightModified(root, diameter);
        return diameter[0];
    }

    private int getHeightModified(TreeNode root, int[] diameter) {
        // Special case
        if (root == null) {
            return 0;
        }
        // Get left and right heights
        int leftHeight = getHeightModified(root.left, diameter);
        int rightHeight = getHeightModified(root.right, diameter);
        // Update the maximum diameter, if required
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        // Return the height of this node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    static class TreeNode {
        final int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
