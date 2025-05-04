package neetcode150.sliding_window;

import java.util.Arrays;

/**
 * @author Created by sunjy on 5/3/25
 */
public class PermutationString {

    //  Are both strings guaranteed to contain only lowercase English letters?
    //  Can either s1 or s2 be empty?
    //  Do we need an exact permutation match as a substring, or just character inclusion?

    //  I count the frequency of each character in s1 and store it in count1.
    //  Then I slide a window of size s1.length() over s2,
    //  maintaining a frequency count count2 for the current window.
    //  At each step, I compare count1 and count2; if they match, we found a valid permutation.

    //  Time O(n)
    //  Space O(1)
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                count2[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }

}
