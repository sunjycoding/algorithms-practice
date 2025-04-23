package leetcode;

/**
 * 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 *
 * @author Created by sunjy on 4/22/25
 */
public class LongestStrictlyIncreasingStrictlyDecreasingSubarray {

    //  I use two counters — one for increasing, one for decreasing.
    //  For each step, I update the counters based on the relation between nums[i] and nums[i-1],
    //  and track the max as I go.

    //  Time O(n)
    //  Space O(1)
    public int longestMonotonicSubarray(int[] nums) {
        return Math.max(getLongest(nums, true), getLongest(nums, false));
    }

    private int getLongest(int[] nums, boolean increasing) {
        int maxLen = 1;
        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((increasing && nums[i] > nums[i - 1]) || (!increasing && nums[i] < nums[i - 1])) {
                curLen++;
            } else {
                curLen = 1;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

}
