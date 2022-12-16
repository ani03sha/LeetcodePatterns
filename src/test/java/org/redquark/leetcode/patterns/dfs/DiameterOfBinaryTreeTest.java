package org.redquark.leetcode.patterns.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.redquark.leetcode.patterns.dfs.DiameterOfBinaryTree.TreeNode;

public class DiameterOfBinaryTreeTest {

    private final DiameterOfBinaryTree testObject = new DiameterOfBinaryTree();

    @Test
    public void testDiameterOfBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        assertEquals(3, testObject.diameterOfBinaryTree(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        assertEquals(1, testObject.diameterOfBinaryTree(root));
    }

    @Test
    public void testDiameterOfBinaryTreeOptimal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        assertEquals(3, testObject.diameterOfBinaryTreeOptimal(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        assertEquals(1, testObject.diameterOfBinaryTreeOptimal(root));
    }
}