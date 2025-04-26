package leetcode;

/**
 * 338. Counting Bits
 *
 * @author Created by sunjy on 4/25/25
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }

}
