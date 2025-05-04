package neetcode150.sliding_window;

/**
 * @author Created by sunjy on 5/3/25
 */
public class BestTimeBuySellStock {

    //  Can the input array be empty or have fewer than two days?
    //  Is it guaranteed that we can only perform one buy and one sell?
    //  Must the sell happen after the buy, or can I reverse the order?

    //  I keep track of the lowest price so far using minPrice.
    //  For each price, I calculate the profit
    //  if I were to sell today and update maxProfit accordingly.

    //  Time O(n)
    //  Space O(1)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
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
