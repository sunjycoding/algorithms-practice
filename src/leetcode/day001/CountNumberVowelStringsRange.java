package leetcode.day001;

import java.util.Set;

/**
 * 2586. Count the Number of Vowel Strings in Range
 *
 * @author Created by sunjy on 3/1/25
 */
public class CountNumberVowelStringsRange {

    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                count++;
            }
        }
        return count;
    }

}
