package leetcode;

/**
 * 45. Jump Game II
 *
 * @author Created by sunjy on 4/16/25
 */
public class JumpGameII {

    //  I use a greedy approach, similar to BFS.
    //  I maintain:
    //  end: the furthest index we can reach with the current number of jumps;
    //  farthest: the furthest index we can reach with the next jump.
    //  When we reach i == end, it means we need to make a jump, so we update end = farthest and increment steps.

    // Time O(n)
    // Space O(1)
    public int jump(int[] nums) {
        int steps = 0;
        int end = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                steps++;
                end = farthest;
            }
        }
        return steps;
    }

}
