package neetcode150.greedy;

/**
 * @author Created by sunjy on 5/13/25
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int ans = 0;
        int farthest = 0;
        int curEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == curEnd) {
                ans++;
                curEnd = farthest;
            }
        }
        return ans;
    }

}
