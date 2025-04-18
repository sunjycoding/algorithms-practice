package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 *
 * @author Created by sunjy on 4/17/25
 */
public class LongestConsecutiveSequence {

    //  I use a HashSet to store all elements for O(1) lookup.
    //  Then I only start expanding from elements that have no predecessor (num - 1 not in the set).
    //  Each number is visited at most once, so the total time complexity is O(n).

    //  Time O(n)
    //  Space O(n)
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
