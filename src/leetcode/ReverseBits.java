package leetcode;

/**
 * 190. Reverse Bits
 *
 * @author Created by sunjy on 4/19/25
 */
public class ReverseBits {

    //  I extract the least significant bit from n and append it to result.
    //  I use unsigned right shift >>> to avoid sign extension in Java.

    //  Time O(32) = O(1)
    //  Space O(1)
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }

}
