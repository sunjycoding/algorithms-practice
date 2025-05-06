package neetcode150.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Created by sunjy on 5/5/25
 */
public class IslandsTreasure {

    //  At least 1 gate?
    //  only 0 1 and inf?
    //  can i modify the grid?

    //  I use multi-source BFS starting from all gates (value 0),
    //  and expand outward layer by layer.
    //  Each step increases the distance by 1,
    //  and since it’s BFS, the first time a room is reached is the shortest path.

    //  Time O(m * n)
    //  Space O(m * n)
    private static final int INF = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != INF) {
                    continue;
                }
                grid[r][c] = grid[row][col] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }

}
