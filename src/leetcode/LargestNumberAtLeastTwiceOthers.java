package leetcode;

/**
 * 747. Largest Number At Least Twice of Others
 *
 * @author Created by sunjy on 4/24/25
 */
public class LargestNumberAtLeastTwiceOthers {

    public int dominantIndex(int[] nums) {
        int max = -1;
        int second = -1;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }

        return max >= 2 * second ? index : -1;
    }

}
