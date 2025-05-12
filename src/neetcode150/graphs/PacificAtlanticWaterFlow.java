package neetcode150.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/11/25
 */
public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
        }
        for (int j = 1; j < n; j++) {
            dfs(heights, 0, j, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlantic);
        }
        for (int j = 0; j < n - 1; j++) {
            dfs(heights, m - 1, j, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, int row, int col, boolean[][] ocean) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length
                    && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, newRow, newCol, ocean);
            }
        }
    }

}
