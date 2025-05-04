package neetcode150.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by sunjy on 5/3/25
 */
public class MinimumWindowSubstring {

    //  Do s and t contain only ASCII characters?
    //  Can t contain duplicate characters?
    //  Can s or t be empty?

    //  I use a HashMap to store character frequencies in t, and a sliding window to scan s.
    //  For each new character at the right,
    //  I update the count and track how many required characters are fully matched (formed++).
    //  Once all required characters are met (formed == number of unique characters in t),
    //  I shrink the left side to minimize the window.
    //  Finally, I return the shortest valid substring found.

    //  Time O(n + m)
    //  Space O(k)
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            tCount.put(key, tCount.getOrDefault(key, 0) + 1);
        }
        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0;
        int start = 0;
        int formed = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0) + 1);
            if (tCount.containsKey(rightChar) && tCount.get(rightChar).equals(windowCount.get(rightChar))) {
                formed++;
            }
            while (formed == tCount.size()) {
                int length = right - left + 1;
                if (length < minLength) {
                    minLength = length;
                    start = left;
                }
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (tCount.containsKey(leftChar) && windowCount.get(leftChar) < tCount.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

}
