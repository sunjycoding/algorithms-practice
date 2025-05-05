package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/4/25
 */
public class LetterCombinationsPhoneNumber {

    //  Can the input contain invalid digits like '1' or '*'?
    //  Can the input string be empty?

    //  I use backtracking to process each digit from left to right.
    //  For each digit, I try all mapped letters.
    //  When the path reaches the full length, I add it to the result list.

    //  Time O(4^n)
    //  Space O(n)
    private final String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> ans) {
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(digits, index + 1, current, ans);
            current.deleteCharAt(current.length() - 1);
        }
    }

}
