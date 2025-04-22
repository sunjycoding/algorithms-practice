package leetcode;

/**
 * 53. Maximum Subarray
 *
 * @author Created by sunjy on 4/20/25
 */
public class MaximumSubarray {

    //  This is Kadane’s Algorithm.
    //  At each step, decide whether to add the current number to the previous sum
    //  or start fresh from the current number:
    //  currentSum = max(nums[i], currentSum + nums[i])
    //  Then update maxSum if currentSum is greater.

    //  Time O(n)
    //  Space O(1);
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}
