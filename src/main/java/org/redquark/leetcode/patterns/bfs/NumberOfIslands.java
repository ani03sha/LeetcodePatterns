package org.redquark.leetcode.patterns.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    /**
     * Time complexity - O(m * n)
     * Space complexity - O(m * n)
     */
    public int numIslands(char[][] grid) {
        // Special case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // Dimensions of the grid
        int m = grid.length;
        int n = grid[0].length;
        // Count of islands
        int islands = 0;
        // Queue for the BFS traversal
        Queue<int[]> cells = new ArrayDeque<>();
        // Array to mark visited cells
        boolean[][] visited = new boolean[m][n];
        // Array to represent four directions
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        // Traverse the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check only for unvisited land cells
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // Mark current cell as visited
                    visited[i][j] = true;
                    // Add the current coordinates to the queue
                    cells.offer(new int[]{i, j});
                    // Perform BFS
                    bfs(grid, m, n, cells, visited, directions);
                    // Update the count of islands
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int m, int n, Queue<int[]> cells, boolean[][] visited, int[][] directions) {
        while (!cells.isEmpty()) {
            // Get the current cell
            int[] currentCell = cells.remove();
            // Check for four neighbors
            for (int[] direction : directions) {
                int x = currentCell[0] + direction[0];
                int y = currentCell[1] + direction[1];
                // Check for boundary conditions
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == '0') {
                    continue;
                }
                // Mark the neighbor as visited
                visited[x][y] = true;
                // Add the neighbor to the queue
                cells.offer(new int[]{x, y});
            }
        }
    }
}
