package neetcode150.bit_manipulation;

/**
 * @author Created by sunjy on 5/11/25
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

}
