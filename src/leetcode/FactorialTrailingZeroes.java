package leetcode;

/**
 * 172. Factorial Trailing Zeroes
 *
 * @author Created by sunjy on 4/17/25
 */
public class FactorialTrailingZeroes {

    //  Instead of computing the factorial,
    //  I count how many times 5 appears in the factorization of numbers up to n.
    //  For example, 5, 10, 15 contribute one 5 each; 25 contributes two (since 25 = 5²).

    //  Time O(log5n)
    //  Space O(1)
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

}
