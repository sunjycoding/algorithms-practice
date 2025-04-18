package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 *
 * @author Created by sunjy on 4/17/25
 */
public class GroupAnagrams {

    //  I use an int[26] to count the frequency of each character in a word.
    //  Then I convert the count array into a string as the hash key.
    //  Words with the same frequency key are grouped together.

    //  Time O(n * k)
    //  Space O(n * k)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

}
