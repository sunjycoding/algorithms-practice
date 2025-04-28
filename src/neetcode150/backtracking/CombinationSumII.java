package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Created by sunjy on 4/27/25
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int index, int currentSum, List<Integer> current, List<List<Integer>> ans) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            ans.add(new ArrayList<>(current));
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currentSum += candidates[i];
            current.add(candidates[i]);
            backtrack(candidates, target, i + 1, currentSum, current, ans);
            currentSum -= candidates[i];
            current.remove(current.size() - 1);
        }
    }

}
