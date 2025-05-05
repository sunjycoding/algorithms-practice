package neetcode150.heap_or_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 5/4/25
 */
public class LastStoneWeight {

    //  I use a max-heap to simulate the process of smashing stones.
    //  Each time, I remove the two largest stones.
    //  If they’re unequal, I insert the difference back into the heap.
    //  This continues until there’s at most one stone left.

    //  Are all stone weights non-negative integers?
    //  Can the input array be empty?
    //  If the final stone weight is zero, should we return it or treat it as "no stone"?
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

}
