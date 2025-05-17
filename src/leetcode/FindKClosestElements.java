package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 658. Find K Closest Elements
 *
 * @author Created by sunjy on 5/16/25
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> distance(a, b, x));
        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>(maxHeap);
        ans.sort(Integer::compareTo);
        return ans;
    }

    private int distance(int a, int b, int x) {
        int ax = Math.abs(a - x);
        int bx = Math.abs(b - x);
        if (ax != bx) {
            return bx - ax;
        } else {
            return b - a;
        }
    }

}
