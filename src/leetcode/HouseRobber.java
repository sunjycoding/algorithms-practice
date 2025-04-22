package leetcode;

/**
 * 198. House Robber
 *
 * @author Created by sunjy on 4/21/25
 */
public class HouseRobber {

    //  I use dynamic programming to decide whether to rob the current house or not.
    //  dp[i] is the max money by robbing up to house i.
    //  The transition is dp[i] = max(dp[i-1], dp[i-2] + nums[i]).
    //  Time O(n)
    //  Space O(n)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

}
