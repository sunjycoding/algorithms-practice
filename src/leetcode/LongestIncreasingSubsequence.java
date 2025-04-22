package leetcode;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 *
 * @author Created by sunjy on 4/21/25
 */
public class LongestIncreasingSubsequence {

    //  I use DP where dp[i] represents the length of the longest increasing subsequence ending at nums[i].
    //  For each previous j < i, if nums[j] < nums[i], I update dp[i] as dp[i] = max(dp[i], dp[j] + 1)

    //  Time O(n^2)
    //  Space O(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}
