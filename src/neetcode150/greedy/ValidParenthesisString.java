package neetcode150.greedy;

/**
 * @author Created by sunjy on 5/13/25
 */
public class ValidParenthesisString {

    //  Can the input string be empty?
    //  Are multiple consecutive * allowed? (yes)
    //  Is performance important? Should I avoid recursion

    //  I track the min and max possible open brackets at each step.
    //  If max goes negative, it's invalid.
    //  At the end, if min is 0, then there's a valid interpretation of * that makes it balanced.

    //  Time O(n)
    //  Space O(1)
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }

}
