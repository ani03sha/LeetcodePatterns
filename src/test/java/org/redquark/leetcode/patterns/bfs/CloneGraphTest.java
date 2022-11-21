package org.redquark.leetcode.patterns.bfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.redquark.leetcode.patterns.bfs.CloneGraph.Node;

public class CloneGraphTest {

    private final CloneGraph testObject = new CloneGraph();

    @Test
    public void testCloneGraph() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors = Arrays.asList(two, four);
        two.neighbors = Arrays.asList(three, one);
        three.neighbors = Arrays.asList(two, three);
        four.neighbors = Arrays.asList(one, four);
        Node expected = testObject.cloneGraph(one);
        assertNotEquals(expected, one);
        assertEquals(1, expected.val);
    }
}