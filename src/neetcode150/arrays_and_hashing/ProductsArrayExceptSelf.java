package neetcode150.arrays_and_hashing;

/**
 * @author Created by sunjy on 5/2/25
 */
public class ProductsArrayExceptSelf {

    //  Can the input array be null or empty?
    //  Can the array contain zeros? What if there are multiple zeros?
    //  Am I allowed to use division?
    //  Can I use extra space beyond the output array?

    //  I build the left prefix products in the output array first.
    //  Then I traverse from right to left,
    //  multiplying the existing value with the running product of right-side elements.

    //  Time O(n)
    //  Space O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int product = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= product;
            product *= nums[i];
        }
        return ans;
    }

}
