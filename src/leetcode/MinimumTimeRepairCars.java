package leetcode;

import java.util.Arrays;

/**
 * 2594. Minimum Time to Repair Cars
 *
 * @author Created by sunjy on 4/22/25
 */
public class MinimumTimeRepairCars {

    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long left = 1;
        long right = (long) ranks[ranks.length - 1] * cars * cars;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepair(mid, ranks, cars)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canRepair(long time, int[] ranks, int cars) {
        long count = 0;
        for (int r : ranks) {
            count += (long) Math.sqrt(time / (double) r);
        }
        return count >= cars;
    }

}
