package leetcode;

/**
 * 200. Number of Islands
 *
 * @author Created by sunjy on 4/23/25
 */
public class NumberIslands {

    //  For each '1' cell, I launch a DFS to sink the entire island by marking all connected '1's as '0'.
    //  This prevents double-counting. I increment the island count each time I do this.

    //  Time O(m * n)
    //  Space O(m * n)
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

}
