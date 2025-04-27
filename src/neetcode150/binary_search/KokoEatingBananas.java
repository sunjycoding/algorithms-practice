package neetcode150.binary_search;

import java.util.Arrays;

/**
 * @author Created by sunjy on 4/26/25
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = calculate(mid, piles);
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int calculate(int k, int[] piles) {
        int hours = 0;
        for (int bananas : piles) {
            hours += (bananas + k - 1) / k;
        }
        return hours;
    }
}
