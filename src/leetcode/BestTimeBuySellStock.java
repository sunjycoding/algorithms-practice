package leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * @author Created by sunjy on 4/16/25
 */
public class BestTimeBuySellStock {

    //  I'll do a single pass through the array, keeping track of the minimum price seen so far.
    //  At each step, I calculate the profit if I sell today (i.e., prices[i] - minPrice)
    //  and update the maximum profit.
    //  At the end, I return the max profit I found.

    //  Time: O(n)
    //  Space: O(1)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

}
