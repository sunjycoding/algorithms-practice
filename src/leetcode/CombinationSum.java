package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * @author Created by sunjy on 4/21/25
 */
public class CombinationSum {

    //  I use backtracking, starting the loop from the current index to allow reusing elements.
    //  If the current sum exceeds the target, I prune.
    //  When it equals the target, I add it to the result. This prevents duplicate combinations.

    //  Time O(2^target)
    //  Space O(target / min(candidate))
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] candidates, int target, int currentSum, List<Integer> current, List<List<Integer>> result) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            currentSum += candidates[i];
            current.add(candidates[i]);
            backtrack(i, candidates, target, currentSum, current, result);
            currentSum -= candidates[i];
            current.removeLast();
        }
    }
}
