package neetcode150.dynamic_programming_1d;

/**
 * @author Created by sunjy on 5/9/25
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currMin = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMin = currMin;
            currMin = Math.min(nums[i], Math.min(currMin * nums[i], currMax * nums[i]));
            currMax = Math.max(nums[i], Math.max(tempMin * nums[i], currMax * nums[i]));
            maxProduct = Math.max(maxProduct, currMax);
        }
        return maxProduct;
    }

}
