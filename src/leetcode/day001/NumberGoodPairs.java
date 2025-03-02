package leetcode.day001;

/**
 * 1512. Number of Good Pairs
 *
 * @author Created by sunjy on 3/1/25
 */
public class NumberGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    result++;
                }
            }
        }
        return result;
    }

}
