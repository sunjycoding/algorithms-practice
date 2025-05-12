package neetcode150.bit_manipulation;

/**
 * @author Created by sunjy on 5/11/25
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
