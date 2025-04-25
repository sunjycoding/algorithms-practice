package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2845. Count of Interesting Subarrays
 *
 * @author Created by sunjy on 4/24/25
 */
public class CountInterestingSubarrays {

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> freq = new HashMap<>();
        freq.put(0, 1L);
        long result = 0;
        int count = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                count++;
            }
            int mod = count % modulo;
            int target = (mod - k + modulo) % modulo;
            result += freq.getOrDefault(target, 0L);
            freq.put(mod, freq.getOrDefault(mod, 0L) + 1);
        }

        return result;
    }

}
