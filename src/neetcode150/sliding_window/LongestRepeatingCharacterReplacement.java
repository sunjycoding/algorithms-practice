package neetcode150.sliding_window;

/**
 * @author Created by sunjy on 5/3/25
 */
public class LongestRepeatingCharacterReplacement {

    //  Are we guaranteed that the string only contains uppercase English letters?
    //  Can k be zero, meaning no replacements allowed?
    //  Are we only looking for contiguous substrings?

    //  I use a sliding window with a frequency array of size 26 to count characters in the window.
    //  At each step, I update the max frequency maxCount in the window.
    //  If the window size minus maxCount exceeds k, I shrink the window from the left.
    //  I keep updating the max length.

    //  Time O(n)
    //  Space O(1)
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int left = 0;
        int[] count = new int[26];
        int maxCount = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            count[ch - 'A']++;
            maxCount = Math.max(maxCount, count[ch - 'A']);
            while ((right - left + 1 - maxCount) > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
