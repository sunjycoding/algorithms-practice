package neetcode150.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/3/25
 */
public class GenerateParentheses {

    //  Is n guaranteed to be at least 1?
    //  Are we required to generate all valid combinations only?

    //  I use backtracking.
    //  At each step, if I still have left parentheses left, I add one.
    //  If the number of right parentheses is less than left, I add a right one.
    //  Once the current string reaches length 2n,
    //  it means it's a valid combination and I add it to the result.

    //  Time O(2^n)
    //  Space O(n)
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(int n, int left, int right, StringBuilder current, List<String> ans) {
        if (current.length() == 2 * n) {
            ans.add(current.toString());
            return;
        }
        if (left < n) {
            current.append('(');
            backtrack(n, left + 1, right, current, ans);
            current.deleteCharAt(current.length() - 1);
        }
        if (right < left) {
            current.append(')');
            backtrack(n, left, right + 1, current, ans);
            current.deleteCharAt(current.length() - 1);
        }
    }

}
