package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * @author Created by sunjy on 4/17/25
 */
public class TwoSum {

    //  I use a HashMap to store the index of each number.
    //  As I iterate, I check if the complement (target - current number) has been seen before.
    //  If yes, return the indices.

    //  Time O(n)
    //  Space O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
