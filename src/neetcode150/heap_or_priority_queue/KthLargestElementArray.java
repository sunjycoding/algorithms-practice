package neetcode150.heap_or_priority_queue;

import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 5/4/25
 */
public class KthLargestElementArray {

    //  Are all inputs guaranteed to be valid integers?
    //  Is it guaranteed that k ≤ nums.length?
    //  Can the array contain duplicate values?

    //  I maintain a min-heap of size k that holds the top k largest elements.
    //  For each number, I add it to the heap and remove the smallest if the heap grows beyond k.
    //  The heap’s top will then be the k-th largest element.
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

}
