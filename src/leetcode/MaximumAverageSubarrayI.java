package leetcode;

/**
 * 643. Maximum Average Subarray I
 *
 * @author Created by sunjy on 5/24/25
 */
public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxAverage = Integer.MIN_VALUE;
        double average = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (right - left + 1 == k) {
                average = sum / k;
                maxAverage = Math.max(maxAverage, average);
                sum -= nums[left];
                left++;
            }
        }
        return maxAverage;
    }

}
