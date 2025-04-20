package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 *
 * @author Created by sunjy on 4/18/25
 */
public class MinimumNumberArrowsBurstBalloons {

    //  I sort the intervals by their end points, then iterate from left to right.
    //  Each time I pick the arrow that bursts the most balloons (greedy).
    //  If a balloon doesn’t overlap with the last arrow’s range, I shoot a new arrow.

    //  Time O(nlogn)
    //  Space O(1)
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }

}
