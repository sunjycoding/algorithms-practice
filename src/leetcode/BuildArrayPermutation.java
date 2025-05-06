package leetcode;

/**
 * 1920. Build Array from Permutation
 *
 * @author Created by sunjy on 5/5/25
 */
public class BuildArrayPermutation {

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

}
