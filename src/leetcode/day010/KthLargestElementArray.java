package leetcode.day010;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 *
 * @author Created by sunjy on 4/5/25
 */
public class KthLargestElementArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        assert minHeap.peek() != null;
        return minHeap.peek();
    }

}
