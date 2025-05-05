package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Created by sunjy on 5/4/25
 */
public class SubsetsII {

    //  Can the input array contain all identical numbers?
    //  Should the subsets be in any specific order?

    //  Since the input may contain duplicates, I sort the array first.
    //  During backtracking, I skip duplicate elements at the same recursion level
    //  using i > index && nums[i] == nums[i - 1] to avoid duplicate subsets.

    //  Time O(2^n)
    //  Space O(n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i + 1, current, ans);
            current.removeLast();
        }
    }

}
