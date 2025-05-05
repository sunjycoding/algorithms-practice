package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/4/25
 */
public class Subsets {

    //  Can the input array contain duplicate numbers?
    //  Is there a specific order required for the subsets?

    //  I use backtracking starting from index 0.
    //  At each recursion level, I choose whether to include the current element.
    //  Every time I recurse, I add the current path to the result.
    //  This generates all possible subsets.

    //  Time O(2^n * n)
    //  Space O(n)
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
            current.removeLast();
        }
    }

}
