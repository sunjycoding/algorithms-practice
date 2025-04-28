package neetcode150.dynamic_programming_1d;

/**
 * @author Created by sunjy on 4/27/25
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
        int rob1 = 0;
        int rob2 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(rob1, rob2 + nums[i]);
            rob2 = rob1;
            rob1 = cur;
        }
        return rob1;
    }

}
