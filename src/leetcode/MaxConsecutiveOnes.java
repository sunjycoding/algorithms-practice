package leetcode;

/**
 * 485. Max Consecutive Ones
 *
 * @author Created by sunjy on 4/24/25
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 1) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 0;
            }
        }
        return Math.max(max, current);
    }

}
