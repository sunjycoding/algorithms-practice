package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 *
 * @author Created by sunjy on 4/18/25
 */
public class SummaryRanges {

    //  I maintain two pointers, start and end, to track the current range.
    //  If the next number is consecutive, I extend the range.
    //  Otherwise, I add the previous range and start a new one.

    //  Time O(n)
    // Space O(1)
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != end + 1) {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
            }
            end = nums[i];
        }
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }
        return result;
    }

}
