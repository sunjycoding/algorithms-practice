package leetcode;

/**
 * 5. Longest Palindromic Substring
 *
 * @author Created by sunjy on 4/22/25
 */
public class LongestPalindromicSubstring {

    //  The idea is to expand around each center.
    //  For each character, you try to expand both odd-length and even-length palindromes.

    //  Time O(n^2)
    //  Space O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int n1 = palindrome(s, i, i);
            int n2 = palindrome(s, i, i + 1);
            int n = Math.max(n1, n2);
            if (n > end - start) {
                start = i - (n - 1) / 2;
                end = i + n / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
