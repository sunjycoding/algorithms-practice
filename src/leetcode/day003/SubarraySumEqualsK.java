package leetcode.day003;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 *
 * @author Created by sunjy on 3/6/25
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> sumFrequency = new HashMap<>();
        int sum = 0;
        sumFrequency.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (sumFrequency.containsKey(sum - k)) {
                count += sumFrequency.get(sum - k);
            }
            sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
