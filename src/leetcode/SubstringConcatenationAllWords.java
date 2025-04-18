package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 *
 * @author Created by sunjy on 4/17/25
 */
public class SubstringConcatenationAllWords {

    //  I use a hashmap to store the frequency of each word in words.
    //  Then I scan s using a sliding window of total size words.length * wordLen.
    //  At each position, I split the window into chunks of wordLen and count each word.
    //  If the current frequency matches the expected one, it's a valid starting index.

    //  Time  O(n * wordLen)
    //  Space O(m)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordFreq.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (windowMap.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    windowMap.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }

}
