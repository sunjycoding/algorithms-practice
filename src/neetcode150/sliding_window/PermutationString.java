package neetcode150.sliding_window;

import java.util.Arrays;

/**
 * @author Created by sunjy on 5/3/25
 */
public class PermutationString {

    //  Can s1 or s2 be empty?
    //  Do the strings contain only lowercase English letters?
    //  Do I just need to return whether a permutation exists, or return all positions?

    //  I’m using a fixed-length sliding window of size equal to s1.length(),
    //  and tracking the character frequencies with two arrays of size 26.
    //  At each step, I compare the two arrays,
    //  and if they match, then the substring is a permutation of s1.

    //  Time O(n)
    //  Space O(1)
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < m; i++) {
            count[s1.charAt(i) - 'a']++;
        }
        int[] windowCount = new int[26];
        int left = 0;
        for (int right = 0; right < n; right++) {
            char rightCh = s2.charAt(right);
            windowCount[rightCh - 'a']++;
            while (right - left + 1 > m) {
                char leftCh = s2.charAt(left);
                windowCount[leftCh - 'a']--;
                left++;
            }
            if (Arrays.equals(count, windowCount)) {
                return true;
            }
        }
        return false;
    }

}
