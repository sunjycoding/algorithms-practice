package leetcode;

/**
 * 392. Is Subsequence
 *
 * @author Created by sunjy on 4/17/25
 */
public class IsSubsequence {

    //  I use two pointers, one for s and one for t.
    //  When s[p1] == t[p2], I advance the s pointer.
    //  If i reaches s.length(), then s is a subsequence of t.

    //  Time O(n)
    //  Space O(1)
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == s.length();
    }

}
