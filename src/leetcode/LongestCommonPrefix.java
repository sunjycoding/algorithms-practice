package leetcode;

/**
 * 14. Longest Common Prefix
 *
 * @author Created by sunjy on 4/16/25
 */
public class LongestCommonPrefix {

    //  I use vertical scanning.
    //  I iterate through each character index of the first string and
    //  compare it with the same index in all other strings.
    //  If a mismatch is found, I return the prefix up to that point.

    // Time O(m * n)
    // Space O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
