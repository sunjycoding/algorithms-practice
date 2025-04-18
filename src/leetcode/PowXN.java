package leetcode;

/**
 * 50. Pow(x, n)
 *
 * @author Created by sunjy on 4/17/25
 */
public class PowXN {

    //  I use fast exponentiation to reduce the time complexity from O(n) to O(log n).
    //  Each step squares the base and halves the exponent.
    //  If n is negative, I convert it to positive and take the reciprocal at the end.
    //  I also handle Integer.MIN_VALUE carefully.

    //  Time O(log n)
    //  Space O(1)
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0;
        while (N > 0) {
            if ((N % 2) == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }
        return result;
    }

}
