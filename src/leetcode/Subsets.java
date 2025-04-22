package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * @author Created by sunjy on 4/21/25
 */
public class Subsets {

    //  I use backtracking to generate all subsets.
    //  For each position, I decide whether to include the current number.
    //  I add the current path to the result at each step.

    //  Time O(2^n*n)
    //  Space O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.removeLast();
        }
    }

}
