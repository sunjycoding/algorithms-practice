package neetcode150.heap_or_priority_queue;

import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 4/27/25
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.offer(Math.abs(stone2 - stone1));
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

}
