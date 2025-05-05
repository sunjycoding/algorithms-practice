package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/4/25
 */
public class CombinationSum {

    //  Can candidates[] contain duplicates?
    //  Are all numbers positive integers?
    //  Can we reuse each number unlimited times?

    //  I use backtracking to explore combinations.
    //  Since we can reuse elements, I recurse starting from the same index.
    //  I also prune early — if the current sum exceeds the target, I return immediately.

    //  Time O(2^t)
    //  Space O(t)
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int target, int index, int currentSum, List<Integer> current, List<List<Integer>> ans) {
        if (currentSum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (currentSum > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            currentSum += nums[i];
            backtrack(nums, target, i, currentSum, current, ans);
            current.removeLast();
            currentSum -= nums[i];
        }
    }

}
