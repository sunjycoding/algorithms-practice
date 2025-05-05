package leetcode;

/**
 * 790. Domino and Tromino Tiling
 *
 * @author Created by sunjy on 5/4/25
 */
public class DominoTrominoTiling {

    public int numTilings(int n) {
        int mod = 1000000007;
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3]) % mod;
        }
        return (int) dp[n];
    }

}
