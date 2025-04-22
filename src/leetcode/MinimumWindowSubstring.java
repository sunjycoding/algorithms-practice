package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 *
 * @author Created by sunjy on 4/17/25
 */
public class MinimumWindowSubstring {

    //  We use a sliding window + character frequency map.
    //  Build a map from string t with required char counts.
    //  Then expand the right side of the window,
    //  and when the current window satisfies all char counts,
    //  try to shrink it from the left to find the smallest valid window.
    //  Update the minimum length and start index when we find a smaller valid window.

    //  Time O(m + n)
    //  Space O(n)
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char key = t.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int left = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int required = map.size();
        Map<Character, Integer> windowCount = new HashMap<>();

        for (int right = 0; right < m; right++) {
            char ch = s.charAt(right);
            windowCount.put(ch, windowCount.getOrDefault(ch, 0) + 1);

            if (map.containsKey(ch) &&
                    map.get(ch).equals(windowCount.get(ch))) {
                count++;
            }

            while (count == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftCh = s.charAt(left);
                windowCount.put(leftCh, windowCount.get(leftCh) - 1);
                if (map.containsKey(leftCh) &&
                        windowCount.get(leftCh) < map.get(leftCh)) {
                    count--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

}
