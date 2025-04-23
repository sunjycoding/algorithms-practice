package leetcode;

/**
 * 72. Edit Distance
 *
 * @author Created by sunjy on 4/22/25
 */
public class EditDistance {

    //  I'd approach this with dynamic programming.
    //  I'd use a 2D array dp[i][j] where dp[i][j] means the minimum number of operations
    //  to convert the first i characters of word1 to the first j of word2.
    //  The transition considers insert, delete, and replace.

    //  Time O(m * n)
    //  Space O(m * n)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
