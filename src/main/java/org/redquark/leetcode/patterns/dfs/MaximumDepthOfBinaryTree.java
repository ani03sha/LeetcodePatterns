package org.redquark.leetcode.patterns.dfs;

public class MaximumDepthOfBinaryTree {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int maxDepth(TreeNode root) {
        // Special case
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
