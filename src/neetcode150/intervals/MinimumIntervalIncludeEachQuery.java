package neetcode150.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 5/1/25
 */
public class MinimumIntervalIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int n = queries.length;
        int[][] queryWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        Arrays.sort(queryWithIndex, Comparator.comparingInt(a -> a[0]));

        int[] res = new int[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int i = 0;

        for (int[] q : queryWithIndex) {
            int query = q[0], idx = q[1];

            while (i < intervals.length && intervals[i][0] <= query) {
                int start = intervals[i][0], end = intervals[i][1];
                if (end >= query) {
                    minHeap.offer(new int[]{end - start + 1, end});
                }
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            res[idx] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return res;
    }

}
