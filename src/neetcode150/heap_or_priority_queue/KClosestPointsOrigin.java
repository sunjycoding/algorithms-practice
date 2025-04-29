package neetcode150.heap_or_priority_queue;

import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 4/28/25
 */
public class KClosestPointsOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> distance(b) - distance(a)
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        for (int[] point : maxHeap) {
            result[i++] = point;
        }

        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}
