package leetcode;

/**
 * 1550. Three Consecutive Odds
 *
 * @author Created by sunjy on 5/10/25
 */
public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i % 2 != 0) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

}
