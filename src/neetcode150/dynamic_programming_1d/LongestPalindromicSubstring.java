package neetcode150.dynamic_programming_1d;

/**
 * @author Created by sunjy on 4/27/25
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int n1 = palindrome(s, i, i);
            int n2 = palindrome(s, i, i + 1);
            int n = Math.max(n1, n2);
            if (n > maxLength) {
                maxLength = n;
                start = i - (n - 1) / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    private int palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
