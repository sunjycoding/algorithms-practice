package leetcode;

/**
 * 201. Bitwise AND of Numbers Range
 *
 * @author Created by sunjy on 4/19/25
 */
public class BitwiseANDNumbersRange {

    //  Whenever there's a change in bits between left and right, those bits will become 0 after AND.
    //  So I keep shifting both numbers to the right until they match,
    //  and then shift back to restore the common prefix.

    //  Time O(1)
    //  Space O(1)
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

}
