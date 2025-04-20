package leetcode;

/**
 * 137. Single Number II
 *
 * @author Created by sunjy on 4/19/25
 */
public class SingleNumberII {

    //  I count how many times bit 1 appears at each position.
    //  Since every other number appears 3 times, taking modulo 3 removes their contribution,
    //  leaving only the unique number's bits.
    //  Since it's 32 bits, time is still O(n).

    //  Time O(32 * n) = O(n)
    //  Space O(1)
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bitCount = 0;

            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    bitCount++;
                }
            }

            if (bitCount % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }

}
