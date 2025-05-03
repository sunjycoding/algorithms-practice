package neetcode150.arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by sunjy on 5/2/25
 */
public class GroupAnagrams {

    //  Can the input array be null or empty?
    //  Are all strings guaranteed to be lowercase English letters?
    //  Can any of the strings be empty?

    //  For each string, I count the frequency of each of the 26 lowercase letters using an int[26] array.
    //  Then I convert that array into a string key for a HashMap, grouping anagrams together.

    //  Time O(n * k)
    //  Space O(n * k)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

}
