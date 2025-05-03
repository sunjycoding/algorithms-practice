package neetcode150.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Created by sunjy on 5/2/25
 */
public class LongestConsecutiveSequence {

    //  Can the input array be null or empty?
    //  Can the array contain duplicate numbers?
    //  Can the array contain negative numbers?

    //  I put all numbers into a Set.
    //  Then, for each number,
    //  I only start a sequence if there's no number before it (i.e., num - 1 doesn't exist).

    //  Time O(n)
    //  Space O(n)
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> count = new HashSet<>();
        for (int num : nums) {
            count.add(num);
        }
        for (int num : nums) {
            if (!count.contains(num - 1)) {
                int current = num;
                int length = 1;
                while (count.contains(current + 1)) {
                    current++;
                    length++;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }

}
