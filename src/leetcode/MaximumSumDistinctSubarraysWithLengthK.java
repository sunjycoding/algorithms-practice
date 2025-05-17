package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K
 *
 * @author Created by sunjy on 5/16/25
 */
public class MaximumSumDistinctSubarraysWithLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currSum = 0;
        Set<Integer> uniqueNum = new HashSet<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (uniqueNum.contains(nums[right])) {
                uniqueNum.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            uniqueNum.add(nums[right]);
            currSum += nums[right];

            while (right - left + 1 > k) {
                uniqueNum.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

}
