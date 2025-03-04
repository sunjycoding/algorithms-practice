package neetcode.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 *
 * @author Created by sunjy on 3/3/25
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
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                result = Math.max(result, currentLength);
            }
        }
        return result;
    }

}
