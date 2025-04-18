package leetcode;

/**
 * 66. Plus One
 *
 * @author Created by sunjy on 4/17/25
 */
public class PlusOne {

    //  I scan the array from the end. If a digit is less than 9, I increment it and return.
    //  If it's 9, I set it to 0 and continue the carry.
    //  If all digits are 9, I create a new array with 1 followed by zeros.

    //  Time O(n)
    //  Space O(n)
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

}
