package leetcode.day002;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 *
 * @author Created by sunjy on 3/5/25
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }

}
