package neetcode150.heap_or_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 5/4/25
 */
public class MedianFinder {

    //  Can the stream contain duplicate numbers?
    //  Are all numbers integers? Can the median be a decimal?
    //  Can findMedian() be called many times after multiple insertions?

    //  I use two heaps: a max-heap for the smaller half and a min-heap for the larger half.
    //  When adding a number, I first insert into the max-heap, then move its top to the min-heap.
    //  If the heaps become unbalanced, I rebalance them by moving the min-heap top back.

    //  addNum() Time O(log n)
    //  Space O(n)
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

}
