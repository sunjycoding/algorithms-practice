package leetcode.day003;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * @author Created by sunjy on 3/6/25
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> uniqueChars = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (uniqueChars.contains(s.charAt(right))) {
                uniqueChars.remove(s.charAt(left));
                left++;
            }
            uniqueChars.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
