package leetcode;

/**
 * 242. Valid Anagram
 *
 * @author Created by sunjy on 4/17/25
 */
public class ValidAnagram {

    //  I use a size-26 integer array to track character counts.
    //  I increment for s, decrement for t, and finally check if all counts are zero.
    //  This confirms if the two strings are anagrams.

    //  Time O(n)
    //  Space O(1)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

}
