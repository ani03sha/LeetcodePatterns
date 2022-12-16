package org.redquark.leetcode.patterns.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.redquark.leetcode.patterns.dfs.MinimumDepthOfBinaryTree.TreeNode;

public class MinimumDepthOfBinaryTreeTest {

    private final MinimumDepthOfBinaryTree testObject = new MinimumDepthOfBinaryTree();

    @Test
    public void testMinDepth() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(2, testObject.minDepth(root));

        root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);
        assertEquals(5, testObject.minDepth(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        assertEquals(2, testObject.minDepth(root));
    }
}