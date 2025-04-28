package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 4/27/25
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, ans);
            current.remove(current.size() - 1);
        }
    }

}
