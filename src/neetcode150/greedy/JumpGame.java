package neetcode150.greedy;

/**
 * @author Created by sunjy on 5/13/25
 */
public class JumpGame {

    //  I’m using a greedy approach. I keep track of the farthest index I can reach.
    //  If I ever find that I can’t reach the current index, I return false.
    //  If the farthest point reaches or exceeds the last index, I return true early.

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
