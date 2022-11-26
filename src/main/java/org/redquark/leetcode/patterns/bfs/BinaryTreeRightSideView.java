package org.redquark.leetcode.patterns.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public List<Integer> rightSideView(TreeNode root) {
        // List to store the right side view
        List<Integer> rightView = new ArrayList<>();
        // Special case
        if (root == null) {
            return rightView;
        }
        // Queue to perform BFS
        Queue<TreeNode> nodes = new ArrayDeque<>();
        // Add root to the queue
        nodes.offer(root);
        // Loop for all nodes in the tree
        while (!nodes.isEmpty()) {
            // Get the nodes at the current level
            int size = nodes.size();
            // Add the last node at the current level in the output
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.remove();
                if (i == size - 1) {
                    rightView.add(node.val);
                }
                // Add left and right children of this node
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
        }
        return rightView;
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
