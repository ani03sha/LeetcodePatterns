package org.redquark.leetcode.patterns.bfs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Node cloneGraph(Node node) {
        // Special case
        if (node == null) {
            return null;
        }
        // Create root of the cloned graph
        Node clone = new Node(node.val);
        // Mappings of the original node and cloned node
        Map<Node, Node> nodeMappings = new HashMap<>();
        // Add root and its clone
        nodeMappings.put(node, clone);
        // Queue to perform BFS on graph
        Queue<Node> nodes = new LinkedList<>();
        // Add root node to the queue
        nodes.offer(node);
        // Loop until the queue is empty
        while (!nodes.isEmpty()) {
            // Pop the node at the front of the queue
            Node current = nodes.remove();
            // Traverse all the neighbors of the node
            for (Node neighbor : current.neighbors) {
                // Create clones if we have not already traversed this node
                if (!nodeMappings.containsKey(neighbor)) {
                    nodeMappings.put(neighbor, new Node(neighbor.val));
                    // Add the neighbor to the queue
                    nodes.offer(neighbor);
                }
                // Add the cloned neighbor to the cloned node
                nodeMappings.get(current).neighbors.add(nodeMappings.get(neighbor));
            }
        }
        return clone;
    }

    static class Node {
        final int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
}
