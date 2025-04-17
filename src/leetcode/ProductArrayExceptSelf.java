package leetcode;

/**
 * 238. Product of Array Except Self
 *
 * @author Created by sunjy on 4/16/25
 */
public class ProductArrayExceptSelf {

    //  First pass from left to right to compute the prefix product — product of all elements before index i.
    //  Second pass from right to left to compute the suffix product and multiply it directly into the result.
    //  This gives us the product of all elements except nums[i], without using division.

    // Time O(n)
    // Space O(n)
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefixProduct = new int[length];
        prefixProduct[0] = 1;
        for (int i = 1; i < length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        int[] result = new int[length];
        int product = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = product * prefixProduct[i];
            product = product * nums[i];
        }
        return result;
    }

}
