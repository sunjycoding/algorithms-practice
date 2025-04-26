package leetcode;

/**
 * 647. Palindromic Substrings
 *
 * @author Created by sunjy on 4/25/25
 */
public class PalindromicSubstrings {

    //  We'll treat each character and the gap between two characters as a "center."
    //  Expand outward around each center and count palindromic substrings.
    //  There are 2n-1 centers total.

    //  Time O(n^2)
    //  Space O(1)
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

}
