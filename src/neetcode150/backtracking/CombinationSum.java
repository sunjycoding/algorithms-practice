package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 4/27/25
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, target, 0, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int target, int index, int currentSum, List<Integer> current, List<List<Integer>> ans) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            currentSum += nums[i];
            backtrack(nums, target, i, currentSum, current, ans);
            current.remove(current.size() - 1);
            currentSum -= nums[i];
        }
    }
}
