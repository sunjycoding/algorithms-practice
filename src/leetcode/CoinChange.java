package leetcode;

import java.util.Arrays;

/**
 * 322. Coin Change
 *
 * @author Created by sunjy on 4/21/25
 */
public class CoinChange {

    //  I use bottom-up DP where dp[i] is the minimum coins needed to make amount i.
    //  I initialize all to amount + 1, which means unreachable, and set dp[0] = 0.
    //  For each amount, I check all coin denominations to update the minimum.

    //  Time O(amount * n)
    //  Space (amount)
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
