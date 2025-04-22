package leetcode;

/**
 * 70. Climbing Stairs
 *
 * @author Created by sunjy on 4/21/25
 */
public class ClimbingStairs {

    //  I use DP where dp[i] means the number of ways to reach step i.
    //  The transition is dp[i] = dp[i - 1] + dp[i - 2],
    //  since we can take 1 or 2 steps at a time.

    //  Time O(n)
    //  Space O(n)
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
