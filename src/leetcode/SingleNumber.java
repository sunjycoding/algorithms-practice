package leetcode;

/**
 * 136. Single Number
 *
 * @author Created by sunjy on 4/19/25
 */
public class SingleNumber {

    //  I use XOR to solve this.
    //  Since a ^ a = 0 and a ^ 0 = a, all duplicate numbers cancel each other out,
    //  leaving the single number.

    //  Time O(n)
    //  Space O(1)
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
