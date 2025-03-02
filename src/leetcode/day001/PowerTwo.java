package leetcode.day001;

/**
 * 231. Power of Two
 *
 * @author Created by sunjy on 3/1/25
 */
public class PowerTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

}
