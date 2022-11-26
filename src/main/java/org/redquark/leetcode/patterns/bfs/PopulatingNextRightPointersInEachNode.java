package org.redquark.leetcode.patterns.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Node connect(Node root) {
        // Special case
        if (root == null) {
            return null;
        }
        // Queue to perform BFS
        Queue<Node> nodes = new ArrayDeque<>();
        // Add root node to the queue
        nodes.offer(root);
        // Traverse the tree in BFS manner
        while (!nodes.isEmpty()) {
            // Count of nodes at the current level
            int size = nodes.size();
            // Loop for all the nodes at the current level
            for (int i = 0; i < size; i++) {
                // Get the current node
                Node node = nodes.remove();
                // If there are nodes at the current level, and they
                // are not the last node at the current level, we
                // will populate the next pointer
                if (!nodes.isEmpty() && i < size - 1) {
                    node.next = nodes.peek();
                }
                // Add left and right children to the queue for
                // further processing
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
        }
        return root;
    }

    static class Node {
        final int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
