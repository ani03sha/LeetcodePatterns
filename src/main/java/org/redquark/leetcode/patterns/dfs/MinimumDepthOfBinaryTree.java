package org.redquark.leetcode.patterns.dfs;

public class MinimumDepthOfBinaryTree {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int minDepth(TreeNode root) {
        // Special case
        if (root == null) {
            return 0;
        }
        // Get depths of left and right subtrees recursively
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // If either of the children is null, we will take max of two heights
        // If both children are present, we will find the min of two heights
        return 1 + (left == 0 || right == 0
                ? Math.max(left, right)
                : Math.min(left, right));
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
