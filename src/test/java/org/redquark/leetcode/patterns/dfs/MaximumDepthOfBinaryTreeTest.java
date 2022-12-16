package org.redquark.leetcode.patterns.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.redquark.leetcode.patterns.dfs.MaximumDepthOfBinaryTree.TreeNode;

public class MaximumDepthOfBinaryTreeTest {

    private final MaximumDepthOfBinaryTree testObject = new MaximumDepthOfBinaryTree();

    @Test
    public void testMaxDepth() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(3, testObject.maxDepth(root));

        root = new TreeNode(1);
        root.right = new TreeNode(2);
        assertEquals(2, testObject.maxDepth(root));

        assertEquals(0, testObject.maxDepth(null));

        root = new TreeNode(0);
        assertEquals(1, testObject.maxDepth(root));
    }
}