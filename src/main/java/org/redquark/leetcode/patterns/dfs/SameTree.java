package org.redquark.leetcode.patterns.dfs;

public class SameTree {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Special cases
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        // Compare the current values
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
