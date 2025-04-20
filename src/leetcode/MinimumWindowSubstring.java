package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 *
 * @author Created by sunjy on 4/17/25
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character key = t.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int left = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < m; right++) {

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

}
