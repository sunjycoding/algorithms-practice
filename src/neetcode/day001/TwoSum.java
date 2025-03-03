package neetcode.day001;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 *
 * @author Created by sunjy on 3/2/25
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int index = map.get(complement);
                return index > i ? new int[]{i, index} : new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
