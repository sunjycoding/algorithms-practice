package neetcode150.graphs;

/**
 * @author Created by sunjy on 5/5/25
 */
public class MaxAreaIsland {

    //  Only 1 and 0?
    //  Can I modify the grid?

    //  I use DFS to expand each island starting from cells with value 1.
    //  During the DFS, I sum up the size of connected land and mark visited cells as 0 to avoid revisits.
    //  I keep track of the maximum area encountered.

    //  Time O(m * n)
    //  Space O(m * n)
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1 +
                dfs(grid, row + 1, col) +
                dfs(grid, row - 1, col) +
                dfs(grid, row, col + 1) +
                dfs(grid, row, col - 1);
    }

}
