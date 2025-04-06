package leetcode.day010;

/**
 * 1863. Sum of All Subset XOR Totals
 *
 * @author Created by sunjy on 4/5/25
 */
public class SumAllSubsetXORTotals {

    int total = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return total;
    }

    private void dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            total += currentXor;
            return;
        }
        dfs(nums, index + 1, currentXor);
        dfs(nums, index + 1, currentXor ^ nums[index]);
    }

}
