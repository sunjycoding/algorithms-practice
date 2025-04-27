package neetcode150.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Created by sunjy on 4/26/25
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }

}
