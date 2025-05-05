package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/4/25
 */
public class Permutations {

    //  Can the input array contain duplicate values?

    //  I use backtracking and try all unused numbers at each level.
    //  I track usage with a used[] array.
    //  When the current path reaches the input length, I add it to the result

    //  Time O(n!)
    //  Space O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> ans) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, ans);
            current.removeLast();
            used[i] = false;
        }
    }

}
