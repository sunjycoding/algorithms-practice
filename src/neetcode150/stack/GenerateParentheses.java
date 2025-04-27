package neetcode150.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 4/26/25
 */
public class GenerateParentheses {

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
