package neetcode150.graphs;

/**
 * @author Created by sunjy on 5/5/25
 */
public class NumberIslands {

    //  Only 1 and 0?
    //  Should modify it in-place?

    //  I use DFS to traverse each island.
    //  When I find a land cell '1' that hasn’t been visited,
    //  I launch DFS from it and mark all connected land as '0'.
    //  Every DFS call corresponds to discovering a new island, so I increment the count

    //  Time O(m * n)
    //  Space O(m * n)
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

}
