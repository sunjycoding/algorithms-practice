package neetcode.day001;

/**
 * Products of Array Except Self
 *
 * @author Created by sunjy on 3/2/25
 */
public class ProductsArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int product = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }

}
