package neetcode150.dynamic_programming_1d;

/**
 * @author Created by sunjy on 4/27/25
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(tempMax * nums[i], min * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }

}
