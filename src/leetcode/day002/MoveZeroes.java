package leetcode.day002;

/**
 * 283. Move Zeroes
 *
 * @author Created by sunjy on 3/5/25
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
