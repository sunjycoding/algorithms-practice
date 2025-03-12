package leetcode.day005;

/**
 * 136. Single Number
 *
 * @author Created by sunjy on 3/11/25
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
