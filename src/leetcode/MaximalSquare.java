package leetcode;

/**
 * 221. Maximal Square
 *
 * @author Created by sunjy on 4/22/25
 */
public class MaximalSquare {

    //  If the current cell is '1', it can only extend a square
    //  if its top, left, and top-left neighbors also support it.
    //  So we take the minimum of the three neighbors and add 1.
    //  This ensures that only squares with all-1s get counted.

    //  Time O(m × n)
    //  Space O(m × n)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLen = 0;

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxLen = Math.max(maxLen, dp[i][0]);
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            maxLen = Math.max(maxLen, dp[0][j]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]
                    ) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }

}
