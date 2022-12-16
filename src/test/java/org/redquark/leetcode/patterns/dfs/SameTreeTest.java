package org.redquark.leetcode.patterns.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.redquark.leetcode.patterns.dfs.SameTree.TreeNode;

public class SameTreeTest {

    private final SameTree sameTree = new SameTree();

    @Test
    public void testIsSameTree() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        assertTrue(sameTree.isSameTree(p, q));

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        q = new TreeNode(1);
        q.right = new TreeNode(2);
        assertFalse(sameTree.isSameTree(p, q));

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);
        q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);
        assertFalse(sameTree.isSameTree(p, q));
    }
}