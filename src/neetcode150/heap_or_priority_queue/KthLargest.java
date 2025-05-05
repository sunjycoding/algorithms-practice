package neetcode150.heap_or_priority_queue;

import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 5/4/25
 */
public class KthLargest {

    //  I use a min-heap to maintain the top k largest elements.
    //  When I add a new number, if the heap size exceeds k, I remove the smallest.
    //  The top of the heap will always be the k-th largest number.

    //  add(val) Time O(log k)
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

}
