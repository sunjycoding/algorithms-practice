package leetcode;

import java.util.Arrays;

/**
 * 2090. K Radius Subarray Averages
 *
 * @author Created by sunjy on 5/24/25
 */
public class KRadiusSubarrayAverages {

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        if (n < 2 * k + 1) {
            return ans;
        }

        long sum = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
        }

        ans[k] = (int) (sum / (2 * k + 1));

        for (int i = 2 * k + 1; i < n; i++) {
            sum += nums[i] - nums[i - (2 * k + 1)];
            ans[i - k] = (int) (sum / (2 * k + 1));
        }

        return ans;
    }

}
