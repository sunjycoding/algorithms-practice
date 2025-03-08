package leetcode.day002;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * @author Created by sunjy on 3/5/25
 */
public class TwoSum {

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
