package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * @author Created by sunjy on 4/17/25
 */
public class LongestSubstringWithoutRepeatingCharacters {

    //  I use two pointers to create a sliding window.
    //  If a duplicate is found, I shrink the window from the left until it becomes unique again.
    //  Then I update the max length.

    //  Time O(n)
    //  Space O(min(n, m))
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        Set<Character> uniqueChars = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (uniqueChars.contains(s.charAt(right))) {
                uniqueChars.remove(s.charAt(left));
                left++;
            }
            uniqueChars.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}
