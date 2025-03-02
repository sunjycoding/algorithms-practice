package leetcode.day001;

/**
 * 326. Power of Three
 *
 * @author Created by sunjy on 3/1/25
 */
public class PowerThree {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

}
