package leetcode;

/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * @author Created by sunjy on 4/16/25
 */
public class BestTimeBuySellStockII {

    //  I use a greedy approach.
    //  If today’s price is higher than yesterday’s, I treat it as one valid transaction: buy yesterday, sell today.
    //  We can sum all such profits — since unlimited transactions are allowed, we can take all upward trends.

    //  Time O(n)
    //  Space O(1)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

}
