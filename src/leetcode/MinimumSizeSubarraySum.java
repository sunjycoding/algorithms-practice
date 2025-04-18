package leetcode;

/**
 * 209. Minimum Size Subarray Sum
 *
 * @author Created by sunjy on 4/17/25
 */
public class MinimumSizeSubarraySum {

    //  I use a sliding window. The right pointer expands the window until the sum is ≥ target,
    //  then I shrink the window from the left to minimize the length.

    //  Time O(n)
    //  Space O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, (right - left + 1));
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
