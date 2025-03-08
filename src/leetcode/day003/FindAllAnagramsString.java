package leetcode.day003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 *
 * @author Created by sunjy on 3/6/25
 */
public class FindAllAnagramsString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        int pLength = p.length();
        for (int i = 0; i < pLength; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }
        for (int i = pLength; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - pLength) - 'a']--;
            if (Arrays.equals(sCount, pCount)) {
                result.add(i - pLength + 1);
            }
        }
        return result;
    }

}
