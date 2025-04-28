package leetcode;

/**
 * 2302. Count Subarrays With Score Less Than K
 *
 * @author Created by sunjy on 4/27/25
 */
public class CountSubarraysWithScoreLessThanK {

    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int left = 0;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            ans += (right - left + 1);
        }
        return ans;
    }

}
