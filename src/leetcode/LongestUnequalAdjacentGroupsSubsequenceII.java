package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2901. Longest Unequal Adjacent Groups Subsequence II
 *
 * @author Created by sunjy on 5/15/25
 */
public class LongestUnequalAdjacentGroupsSubsequenceII {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        ans.add(words[0]);
        set.add(groups[0]);
        int prev = groups[0];
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != prev && !set.contains(groups[i])) {
                ans.add(words[i]);
                set.add(groups[i]);
                prev = groups[i];
            }
        }
        return ans;
    }

}
