package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * @author Created by sunjy on 4/21/25
 */
public class GenerateParentheses {

    //  I use backtracking to generate all valid parentheses combinations.
    //  I add a '(' if we haven’t used all n yet, and add a ')' only if there are more '(' than ')'.
    //  I use StringBuilder for efficiency, and backtrack by deleting the last char.

    //  Time O(4^n / √n)
    //  Space O(n)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtrack(n, 0, 0, path, result);
        return result;
    }

    private void backtrack(int n, int left, int right, StringBuilder path, List<String> result) {
        if (path.length() == n * 2) {
            result.add(path.toString());
            return;
        }

        if (left < n) {
            path.append('(');
            backtrack(n, left + 1, right, path, result);
            path.deleteCharAt(path.length() - 1);
        }

        if (right < left) {
            path.append(')');
            backtrack(n, left, right + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
