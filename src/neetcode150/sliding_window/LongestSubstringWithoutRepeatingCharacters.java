package neetcode150.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Created by sunjy on 4/26/25
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            result = Math.max(right - left + 1, result);
        }
        return result;
    }

}
