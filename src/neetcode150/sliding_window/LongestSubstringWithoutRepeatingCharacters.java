package neetcode150.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Created by sunjy on 5/3/25
 */
public class LongestSubstringWithoutRepeatingCharacters {

    //  Can the input string be empty?
    //  Can the string contain spaces, symbols, or mixed casing?
    //  Should we consider only substrings, or can characters be non-contiguous?

    //  I use a HashSet to track characters in the current window.
    //  I expand the right pointer, and if I encounter a duplicate,
    //  I shrink the left pointer until the window is valid again.
    //  I update the max length at each step.

    //  Time O(n)
    //  Space O(k)
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> count = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (count.contains(ch)) {
                count.remove(s.charAt(left));
                left++;
            }
            count.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
