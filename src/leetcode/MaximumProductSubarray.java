package leetcode;

/**
 * 152. Maximum Product Subarray
 *
 * @author Created by sunjy on 4/25/25
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = maxProd;
            maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            minProd = Math.min(nums[i], Math.min(tempMax * nums[i], minProd * nums[i]));
            result = Math.max(result, maxProd);
        }

        return result;
    }

}
