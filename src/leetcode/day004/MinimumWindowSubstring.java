package leetcode.day004;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 *
 * @author Created by sunjy on 3/8/25
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tCharCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tCharCount.put(ch, tCharCount.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowCharCount = new HashMap<>();
        int left = 0;
        int right = 0;
        int formed = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int required = tCharCount.size();

        while (right < s.length()) {
            char ch = s.charAt(right);
            windowCharCount.put(ch, windowCharCount.getOrDefault(ch, 0) + 1);

            if (tCharCount.containsKey(ch) && windowCharCount.get(ch).intValue() == tCharCount.get(ch).intValue()) {
                formed++;
            }

            while (formed == required) {
                char leftChar = s.charAt(left);
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (tCharCount.containsKey(leftChar) && windowCharCount.get(leftChar) < tCharCount.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

}
