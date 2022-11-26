package org.redquark.leetcode.patterns.bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.redquark.leetcode.patterns.bfs.PopulatingNextRightPointersInEachNodeII.Node;

public class PopulatingNextRightPointersInEachNodeIITest {

    private final PopulatingNextRightPointersInEachNodeII testObject = new PopulatingNextRightPointersInEachNodeII();

    @Test
    public void testConnectSuboptimal() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        Node expected = testObject.connectSuboptimal(root);
        assertNull(expected.next);
    }

    @Test
    public void testConnectOptimal() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        Node expected = testObject.connectOptimal(root);
        assertNull(expected.next);
    }
}