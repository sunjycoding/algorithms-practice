package neetcode150.heap_or_priority_queue;

import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 5/4/25
 */
public class KClosestPointsOrigin {

    //  Can the coordinates of points be negative?
    //  Can the input contain duplicate points?
    //  Should the result be sorted in any specific order?

    //  I use a max-heap of size k to keep track of the k closest points.
    //  For each new point, I add it to the heap and if the size exceeds k, I remove the farthest one.
    //  In the end, the heap contains the k closest points to the origin.

    //  Time O(n log k)
    //  Space O(k)
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> distance(b[0], b[1]) - distance(a[0], a[1]));
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            ans[i] = maxHeap.poll();
            i++;
        }
        return ans;
    }

    private int distance(int x, int y) {
        return x * x + y * y;
    }

}
