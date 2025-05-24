package leetcode;

import java.util.Set;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * @author Created by sunjy on 5/24/25
 */
public class MaximumNumberVowelsSubstringGivenLength {

    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int left = 0;
        int count = 0;
        int maxCount = 0;
        for (int right = 0; right < s.length(); right++) {
            if (vowels.contains(s.charAt(right))) {
                count++;
            }
            while (right - left + 1 == k) {
                maxCount = Math.max(maxCount, count);
                if (vowels.contains(s.charAt(left))) {
                    count--;
                }
                left++;
            }
        }
        return maxCount;
    }

}
