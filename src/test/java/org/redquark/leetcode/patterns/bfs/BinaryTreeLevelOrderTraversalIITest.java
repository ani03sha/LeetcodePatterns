package org.redquark.leetcode.patterns.bfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.redquark.leetcode.patterns.bfs.BinaryTreeLevelOrderTraversalII.TreeNode;

public class BinaryTreeLevelOrderTraversalIITest {

    private final BinaryTreeLevelOrderTraversalII testObject = new BinaryTreeLevelOrderTraversalII();

    @Test
    public void testLevelOrderBottom() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(15, 7));
        expected.add(Arrays.asList(9, 20));
        expected.add(Collections.singletonList(3));
        assertEquals(expected, testObject.levelOrderBottom(root));

        root = new TreeNode(1);
        expected = new ArrayList<>();
        expected.add(Collections.singletonList(1));
        assertEquals(expected, testObject.levelOrderBottom(root));

        assertEquals(Collections.emptyList(), testObject.levelOrderBottom(null));
    }
}