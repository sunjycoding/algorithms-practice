package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 *
 * @author Created by sunjy on 4/20/25
 */
public class FindKPairsSmallestSums {

    //  I take advantage of the fact that both arrays are sorted.
    //  I start by pushing the first k pairs (i, 0) into the min-heap.
    //  Then I repeatedly pop the smallest pair (i, j) and push its next pair (i, j+1) into the heap.
    //  This ensures each pop gives the current smallest sum.

    //  Time O(k log k)
    //  Space O(k)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, (o1, o2) ->
                nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        List<List<Integer>> result = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            minHeap.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[pair[0]]);
            list.add(nums2[pair[1]]);
            result.add(list);
            if (pair[1] + 1 < n) {
                minHeap.offer(new int[]{pair[0], pair[1] + 1});
            }
        }

        return result;
    }

}
