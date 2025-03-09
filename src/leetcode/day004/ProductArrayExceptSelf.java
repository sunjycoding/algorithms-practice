package leetcode.day004;

/**
 * 238. Product of Array Except Self
 *
 * @author Created by sunjy on 3/8/25
 */
public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftProduct = new int[length];
        leftProduct[0] = 1;
        for (int i = 1; i < length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        int[] result = new int[length];
        int product = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = product * leftProduct[i];
            product = product * nums[i];
        }
        return result;
    }

}
