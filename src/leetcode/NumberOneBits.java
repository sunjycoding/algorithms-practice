package leetcode;

/**
 * 191. Number of 1 Bits
 *
 * @author Created by sunjy on 4/19/25
 */
public class NumberOneBits {

    //  If only non-negative numbers are allowed,
    //  I can use % 2 and / 2 to extract bits.
    //  To improve performance, I replace them with bitwise operations: n & 1 and unsigned right shift >>>.

    //  Time O(32) = O(1)
    //  Space O(1)
    public int hammingWeight(int n) {
        int count = 0;
        while (n >= 1) {
            if (n % 2 == 1) {
                count++;
            }
            n = n / 2;
        }
        return count;
    }

}
