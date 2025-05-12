package neetcode150.dynamic_programming_1d;

import java.util.Arrays;

/**
 * @author Created by sunjy on 5/8/25
 */
public class CoinChange {

    //  Can the coins array be empty?
    //  Should I return 0 if amount is 0?
    //  Are coin values guaranteed to be positive?
    //  If no combination is possible, should I return -1?

    //  I’m using bottom-up dynamic programming.
    //  dp[i] represents the minimum number of coins needed to make amount i.
    //  I initialize the array with amount + 1 as an impossible high value.
    //  Then I iterate from 0 to amount, and for each amount,
    //  I try all coins to see if using this coin leads to a smaller number of coins.
    //  In the end, if dp[amount] wasn’t updated, I return -1.

    //  Time O(amount * n)
    //  Space O(amount)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
