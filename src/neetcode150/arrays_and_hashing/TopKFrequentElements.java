package neetcode150.arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 5/2/25
 */
public class TopKFrequentElements {

    //  Can the input array be null or empty?
    //  Can the array contain negative numbers?
    //  What is the range of k? Can k be zero or larger than the array length?
    //  Should the result be sorted by frequency or is any order acceptable?

    // I count frequencies using a HashMap.
    // Then I use a min-heap of size k to keep the top k frequent elements.
    // If the heap exceeds size k, I remove the smallest.

    //  Time O(n)
    //  Space O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = Objects.requireNonNull(minHeap.poll()).getKey();
        }
        return ans;
    }

}
