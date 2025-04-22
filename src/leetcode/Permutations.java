package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * @author Created by sunjy on 4/21/25
 */
public class Permutations {

    //  I’m using in-place backtracking.
    //  At each level, I fix the current index by swapping it with every candidate from index onward.
    //  This explores all permutations. I swap back to backtrack.

    //  Time O(n!)
    //  space O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrack(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
