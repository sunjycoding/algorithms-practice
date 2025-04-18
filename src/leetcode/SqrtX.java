package leetcode;

/**
 * 69. Sqrt(x)
 *
 * @author Created by sunjy on 4/17/25
 */
public class SqrtX {

    //  I use binary search to find the largest integer mid in [1, x/2] such that mid * mid <= x.
    //  To avoid integer overflow during multiplication, I cast the result to long.

    //  Time O(log x)
    //  Space O(1)
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long calculation = (long) mid * mid;
            if (calculation < x) {
                left = mid + 1;
            } else if (calculation > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }

}
