package leetcode;

/**
 * 918. Maximum Sum Circular Subarray
 *
 * @author Created by sunjy on 4/21/25
 */
public class MaximumSumCircularSubarray {

    //  I’ll use Kadane’s algorithm to get both max subarray sum and min subarray sum.
    //  The result is either the normal max subarray or the total sum minus the min subarray (for circular wrap-around).
    //  If all elements are negative, I return the standard max subarray since the circular result would be zero.

    //  Time O(n)
    //  Space O(1)
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = nums[0];
        int curMax = 0;
        int minSum = nums[0];
        int curMin = 0;

        for (int num : nums) {
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);

            total += num;
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, total - minSum);
    }

}
