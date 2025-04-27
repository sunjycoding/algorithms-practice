package neetcode150.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by sunjy on 4/26/25
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            tCount.put(key, tCount.getOrDefault(key, 0) + 1);
        }
        int left = 0;
        int start = 0;
        int minLength = m + 1;
        int count = 0;
        int required = tCount.size();
        Map<Character, Integer> windowCount = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char rightCh = s.charAt(right);
            windowCount.put(rightCh, windowCount.getOrDefault(rightCh, 0) + 1);
            if (tCount.containsKey(rightCh) &&
                    tCount.get(rightCh).equals(windowCount.get(rightCh))) {
                count++;
            }
            while (count == required) {
                int newLength = right - left + 1;
                if (newLength < minLength) {
                    minLength = newLength;
                    start = left;
                }

                char leftCh = s.charAt(left);
                windowCount.put(leftCh, windowCount.get(leftCh) - 1);
                if (tCount.containsKey(leftCh) &&
                        windowCount.get(leftCh) < tCount.get(leftCh)) {
                    count--;
                }

                left++;
            }
        }
        return minLength == (m + 1) ? "" : s.substring(start, start + minLength);
    }

}
