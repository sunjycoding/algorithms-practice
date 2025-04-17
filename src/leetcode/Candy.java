package leetcode;

import java.util.Arrays;

/**
 * 135. Candy
 *
 * @author Created by sunjy on 4/16/25
 */
public class Candy {

    //  I use a two-pass greedy approach:
    //  First pass: from left to right,
    //  if a child has a higher rating than the left neighbor,
    //  give them more candies.
    //  Second pass: from right to left,
    //  do the same, but make sure each child also gets more candies than the right neighbor if needed.

    //  Time O(n)
    //  Space O(1)
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

}
