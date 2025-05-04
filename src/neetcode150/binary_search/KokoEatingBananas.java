package neetcode150.binary_search;

import java.util.Arrays;

/**
 * @author Created by sunjy on 5/3/25
 */
public class KokoEatingBananas {

    //  Are all elements in the piles array guaranteed to be positive integers?
    //  Is h always greater than or equal to the number of piles?
    //  Is Koko allowed to eat fractions of a pile, or only whole bananas per hour?

    //  I apply binary search on the answer.
    //  We're looking for the minimum speed k such that Koko can finish all the piles within h hours.
    //  For a given k, I calculate how many hours it would take.
    //  If it's more than h, then k is too small.
    //  Otherwise, I try smaller values.

    //  Time O(n * logm)
    //  Space O(1)
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
