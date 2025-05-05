package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/4/25
 */
public class PalindromePartitioning {

    //  Can the input string be empty?
    //  Is the palindrome check case-sensitive?
    //  Should we return all valid partitions or just one?

    //  I use backtracking to explore the string from left to right.
    //  At each step, I try to cut a substring s[index...i],
    //  and if it’s a palindrome, I continue to backtrack from i+1.
    //  Once I reach the end, I add the current partition to the result.

    //  Time O(n * 2^n)
    //  Space O(n)
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String s, int index, List<String> current, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (palindrome(s, index, i)) {
                current.add(s.substring(index, i + 1));
                backtrack(s, i + 1, current, ans);
                current.removeLast();
            }
        }
    }

    private boolean palindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
