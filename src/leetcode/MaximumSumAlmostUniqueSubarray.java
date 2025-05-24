package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2841. Maximum Sum of Almost Unique Subarray
 *
 * @author Created by sunjy on 5/24/25
 */
public class MaximumSumAlmostUniqueSubarray {

    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> distinct = new HashMap<>();
        long maxSum = 0;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < nums.size(); right++) {
            int rightNum = nums.get(right);
            sum += rightNum;
            distinct.put(rightNum, distinct.getOrDefault(rightNum, 0) + 1);
            while (right - left + 1 == k) {
                if (distinct.size() >= m) {
                    maxSum = Math.max(maxSum, sum);
                }
                int leftNum = nums.get(left);
                distinct.put(leftNum, distinct.get(leftNum) - 1);
                if (distinct.get(leftNum) == 0) {
                    distinct.remove(leftNum);
                }
                sum -= leftNum;
                left++;
            }
        }
        return maxSum;
    }

}
