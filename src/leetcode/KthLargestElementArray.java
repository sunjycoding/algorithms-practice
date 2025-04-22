package leetcode;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 *
 * @author Created by sunjy on 4/20/25
 */
public class KthLargestElementArray {

    //  I maintain a min-heap of size k to keep track of the top k largest elements.
    //  When a new number comes in, if the heap exceeds size k,
    //  I remove the smallest. In the end, the top of the heap is the k-th largest.

    //  Time O(nlogk)
    //  Space O(k)
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
