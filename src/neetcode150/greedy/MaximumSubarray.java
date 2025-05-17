package neetcode150.greedy;

/**
 * @author Created by sunjy on 5/13/25
 */
public class MaximumSubarray {

    //  I’m using Kadane’s Algorithm.
    //  At each step, I track the max subarray ending at that index.
    //  If the running sum is less than the current element, I reset.
    //  I maintain the max seen so far.

    //  Time O(n)
    //  Space O(1)
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            ans = Math.max(ans, cur);
        }
        return ans;
    }

}
