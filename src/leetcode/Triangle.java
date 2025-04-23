package leetcode;

import java.util.List;

/**
 * 120. Triangle
 *
 * @author Created by sunjy on 4/22/25
 */
public class Triangle {

    //  We’re using a bottom-up DP approach.
    //  We start from the second last row and move upwards.
    //  For each element, we choose the min of the two adjacent values from the row below, and add the current value.

    //  Time O(n^2)
    //  Space O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }

        return dp[0];
    }

}
