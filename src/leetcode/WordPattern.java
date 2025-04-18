package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 *
 * @author Created by sunjy on 4/17/25
 */
public class WordPattern {

    //  This problem is essentially the same as isomorphic strings.
    //  I use two hash maps to track the bidirectional mapping
    //  between pattern characters and words to ensure one-to-one correspondence.

    //  Time O(n)
    //  Space O(n)
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (map1.containsKey(c)) {
                if (!map1.get(c).equals(word)) {
                    return false;
                }
            } else {
                map1.put(c, word);
            }

            if (map2.containsKey(word)) {
                if (map2.get(word) != c) {
                    return false;
                }
            } else {
                map2.put(word, c);
            }
        }

        return true;
    }

}
