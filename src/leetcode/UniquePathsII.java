package leetcode;

/**
 * 63. Unique Paths II
 *
 * @author Created by sunjy on 4/22/25
 */
public class UniquePathsII {

    //  We define dp[i][j] as the number of ways to reach cell (i, j).
    //  If obstacleGrid[i][j] == 1, then it's blocked, so dp[i][j] = 0.
    //  Otherwise, dp[i][j] = dp[i-1][j] + dp[i][j-1].

    //  Time O(m × n)
    //  Space O(m × n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
