package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * @author Created by sunjy on 4/18/25
 */
public class MergeIntervals {

    //  I sort the intervals by their start point, then iterate through them while maintaining a result list.
    //  If the current interval does not overlap with the last one, I add it.
    //  If it does, I merge them by updating the end of the last interval.

    //  Time O(nlogn)
    //  Space O(n)
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>(intervals.length);
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
