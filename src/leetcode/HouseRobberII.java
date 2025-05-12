package leetcode;

/**
 * 213. House Robber II
 *
 * @author Created by sunjy on 5/10/25
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int robPrev = 0;
        int robPrevPrev = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(robPrev, robPrevPrev + nums[i]);
            robPrevPrev = robPrev;
            robPrev = cur;
        }
        return robPrev;
    }

}
