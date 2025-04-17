package leetcode;

/**
 * 55. Jump Game
 *
 * @author Created by sunjy on 4/16/25
 */
public class JumpGame {

    //  I keep a variable farthest to track the furthest index we can reach so far.
    //  For each index i, if i <= farthest, we update farthest = max(farthest, i + nums[i]).
    //  If at any point farthest >= nums.length - 1, it means we can reach the end — return true.
    //  If we finish the loop without reaching the end, return false.

    //  Time O(n)
    //  Space O(1)
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }

}
