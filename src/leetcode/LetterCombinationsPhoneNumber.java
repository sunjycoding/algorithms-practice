package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * @author Created by sunjy on 4/21/25
 */
public class LetterCombinationsPhoneNumber {

    //  I use backtracking to explore all possible letter combinations.
    //  At each digit, I iterate over its mapped characters, append to the path,
    //  and recurse to the next digit.
    //  Once the path reaches the full length, I add it to the result. I use StringBuilder for efficiency

    //  Time O(4^n)
    //  Space O(n)
    String[] strings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        String letters = strings[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, index + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
