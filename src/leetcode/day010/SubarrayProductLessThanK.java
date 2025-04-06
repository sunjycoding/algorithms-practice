package leetcode.day010;

/**
 * 713. Subarray Product Less Than K
 *
 * @author Created by sunjy on 4/5/25
 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int result = 0;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }

}
