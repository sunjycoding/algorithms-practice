package leetcode;

/**
 * 67. Add Binary
 *
 * @author Created by sunjy on 4/19/25
 */
public class AddBinary {

    //  I simulate binary addition from the end of both strings.
    //  At each step, I add the two digits and the carry,
    //  append the current digit to the result, and update the carry.
    //  Finally, I reverse the result string.

    //  Time O(max(m, n))
    //  Space O(max(m, n))
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }

}
