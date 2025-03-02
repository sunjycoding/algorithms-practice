package leetcode.day001;

/**
 * 263. Ugly Number
 *
 * @author Created by sunjy on 3/1/25
 */
public class UglyNumber {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

}
