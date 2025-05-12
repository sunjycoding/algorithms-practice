package leetcode;

/**
 * 1646. Get Maximum in Generated Array
 *
 * @author Created by sunjy on 5/10/25
 */
public class GetMaximumGeneratedArray {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
