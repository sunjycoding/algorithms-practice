package leetcode;

/**
 * 371. Sum of Two Integers
 *
 * @author Created by sunjy on 4/25/25
 */
public class SumTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

}
