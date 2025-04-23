package leetcode;

import java.util.PriorityQueue;

/**
 * 3066. Minimum Operations to Exceed Threshold Value II
 *
 * @author Created by sunjy on 4/22/25
 */
public class MinimumOperationsExceedThresholdValueII {

    //  I use a min-heap to always fetch the two smallest values.
    //  I combine them using the formula 2 * x + y, insert the result back,
    //  and repeat until the smallest element is at least k. The result is the number of operations needed.

    //  Time O(nlogn)
    //  Space O(n)
    public int minOperations(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer((long) num);
        }
        while (minHeap.peek() < k && minHeap.size() >= 2) {
            long val1 = minHeap.poll();
            long val2 = minHeap.poll();
            long cal = val1 * 2 + val2;
            minHeap.offer(cal);
            result++;
        }
        if (minHeap.peek() < k) {
            return -1;
        }
        return result;
    }

}
