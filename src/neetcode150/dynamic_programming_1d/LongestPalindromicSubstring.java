package neetcode150.dynamic_programming_1d;

/**
 * @author Created by sunjy on 5/8/25
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = palindrome(s, i, i);
            int l2 = palindrome(s, i, i + 1);
            int l = Math.max(l1, l2);
            if (l > maxLength) {
                maxLength = l;
                start = i - (l - 1) / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    private int palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
