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

    //  I'm using the sliding window + HashMap approach.
    //  First, I count the frequency of each character in t.
    //  Then I expand the window over s while maintaining the character frequencies in the current window.
    //  Once the window covers all characters from t,
    //  I try to shrink it and update the minimum window length.

    //  Time O(n + m)
    //  Space O(m + n)
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) {
            return "";
        }
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> windowCount = new HashMap<>();
        int start = 0;
        int minLength = n + 1;
        int required = tCount.size();
        int formed = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char rightCh = s.charAt(right);
            windowCount.put(rightCh, windowCount.getOrDefault(rightCh, 0) + 1);
            if (tCount.containsKey(rightCh) && tCount.get(rightCh).equals(windowCount.get(rightCh))) {
                formed++;
            }
            while (formed == required) {
                int length = right - left + 1;
                if (length < minLength) {
                    minLength = length;
                    start = left;
                }
                char leftCh = s.charAt(left);
                windowCount.put(leftCh, windowCount.get(leftCh) - 1);
                left++;
                if (tCount.containsKey(leftCh) && tCount.get(leftCh) > windowCount.get(leftCh)) {
                    formed--;
                }
            }
        }
        return minLength == n + 1 ? "" : s.substring(start, start + minLength);
    }

}
